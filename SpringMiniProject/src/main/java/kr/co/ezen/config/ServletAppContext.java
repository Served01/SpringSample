package kr.co.ezen.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.interceptor.CheckLoginInterceptor;
import kr.co.ezen.interceptor.CheckWriterInterceptor;
import kr.co.ezen.interceptor.TopMenuInterceptor;
import kr.co.ezen.mapper.BoardMapper;
import kr.co.ezen.mapper.TopMenuMapper;
import kr.co.ezen.mapper.UserMapper;
import kr.co.ezen.service.BoardService;
import kr.co.ezen.service.TopMenuService;

@Configuration
//Controller 
@EnableWebMvc
@ComponentScan("kr.co.ezen.controller")
@ComponentScan("kr.co.ezen.dao")
@ComponentScan("kr.co.ezen.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{
	
	@Value("${db.classname}") // oracle.jdbc.OracleDriver
	private String db_classname;
	
	@Value("${db.url}")  // jdbc:oracle:thin:@localhost:1521:xe
	private String db_url;
	
	@Value("${db.username}") // hyun3
	private String db_username;
	
	@Value("${db.password}") // 1234
	private String db_password;
	
	@Autowired //call by Type
	private TopMenuService topMenuService;
	
	@Autowired
	private UserDataBean loginUserDataBean;
	
	@Autowired
	private BoardService boardService;
	
	// Controller.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//?????????????????? ?????? ?????? ???????????? ??? ??????
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		
		source.setDriverClassName(db_classname); 
		source.setUrl(db_url); 
		source.setUsername(db_username); 
		source.setPassword(db_password); 
		
		return source;		
	}
	
	//Query?????? ?????? ????????? ???????????? ?????? ??????
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		
		SqlSessionFactoryBean fSessionFactory = new SqlSessionFactoryBean();
		fSessionFactory.setDataSource(source); 
		
		SqlSessionFactory factory = fSessionFactory.getObject(); 
				
		return factory;		
	}
	
	//Query ????????? ?????? ????????? ??????(Mapper ??????)
	@Bean
	public MapperFactoryBean<BoardMapper> getMapperFactoryBean(SqlSessionFactory factory){
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		
		factoryBean.setSqlSessionFactory(factory); 
		
		return factoryBean;
		
	}
	
	//TopMenuMapper ??????
	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuList(SqlSessionFactory factory){
		MapperFactoryBean<TopMenuMapper> factoryBean = 
				new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		
		factoryBean.setSqlSessionFactory(factory); 
				
		return factoryBean;		
	}
	
	//UserMapper ??????
		@Bean
		public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory){
			MapperFactoryBean<UserMapper> factoryBean = 
					new MapperFactoryBean<UserMapper>(UserMapper.class);
			
			factoryBean.setSqlSessionFactory(factory); 
			
			return factoryBean;		
		}
		
	// Secure Coding
	// ?????? ?????? ????????? ????????? ??????????????? ??????????????? ?????? ?????????.(/**) 
	
	public void addInterceptors(InterceptorRegistry registry) {
		
		WebMvcConfigurer.super.addInterceptors(registry);	
		
		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService, loginUserDataBean);		
		InterceptorRegistration registration1 = registry.addInterceptor(topMenuInterceptor);
			
		registration1.addPathPatterns("/**");		
		
		//CheckLoginInterceptor ?????? : ????????????, ????????????
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserDataBean);
		
		InterceptorRegistration registration2 = registry.addInterceptor(checkLoginInterceptor);
		
		registration2.addPathPatterns("/user/modify", "/user/logout", "/board/*");// ???????????? ??????????????? ??????
		registration2.excludePathPatterns("/board/main"); // ???????????? ??????
		
		
		//????????? ?????? ?????? ??????
		CheckWriterInterceptor checkWriterInterceptor = new CheckWriterInterceptor(loginUserDataBean,boardService);
		InterceptorRegistration reg3 = registry.addInterceptor(checkWriterInterceptor);
		reg3.addPathPatterns("/board/modify","/board/delete");	
		
	}
	
	// ????????? ???????????? properties ????????? ???????????? ????????? ?????????.
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	//????????? ??????
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		
		res.setBasenames("/WEB-INF/properties/error_message");
		
		return res; 
	}	
	
	// ?????????????????????????????????????????? ?????? (upload/download ??????)
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		
		return new StandardServletMultipartResolver();
	}
	
	
}












