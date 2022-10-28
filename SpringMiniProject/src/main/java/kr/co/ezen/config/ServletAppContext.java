package kr.co.ezen.config;

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
import kr.co.ezen.interceptor.TopMenuInterceptor;
import kr.co.ezen.mapper.BoardMapper;
import kr.co.ezen.mapper.TopMenuMapper;
import kr.co.ezen.mapper.UserMapper;
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
	
	//데이터베이스 접속 정보 관리하는 빈 등록
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		
		source.setDriverClassName(db_classname); 
		source.setUrl(db_url); 
		source.setUsername(db_username); 
		source.setPassword(db_password); 
		
		return source;		
	}
	
	//Query문과 접속 정보를 관리하는 객체 생성
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		
		SqlSessionFactoryBean fSessionFactory = new SqlSessionFactoryBean();
		fSessionFactory.setDataSource(source); 
		
		SqlSessionFactory factory = fSessionFactory.getObject(); 
				
		return factory;		
	}
	
	//Query 실행을 위한 객체를 관리(Mapper 관리)
	@Bean
	public MapperFactoryBean<BoardMapper> getMapperFactoryBean(SqlSessionFactory factory){
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		
		factoryBean.setSqlSessionFactory(factory); 
		
		return factoryBean;
		
	}
	
	//TopMenuMapper 등록
	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuList(SqlSessionFactory factory){
		MapperFactoryBean<TopMenuMapper> factoryBean = 
				new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		
		factoryBean.setSqlSessionFactory(factory); 
				
		return factoryBean;		
	}
	
	//UserMapper 등록
		@Bean
		public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory){
			MapperFactoryBean<UserMapper> factoryBean = 
					new MapperFactoryBean<UserMapper>(UserMapper.class);
			
			factoryBean.setSqlSessionFactory(factory); 
			
			return factoryBean;		
		}
	
	
	
	
	// Secure Coding
	// 모든 요청 주소는 무조건 인터셉터를 통과하도록 해야 합니다.(/**) 
	
	public void addInterceptors(InterceptorRegistry registry) {
		
		WebMvcConfigurer.super.addInterceptors(registry);	
		
		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService, loginUserDataBean);		
		InterceptorRegistration registration1 = registry.addInterceptor(topMenuInterceptor);
			
		registration1.addPathPatterns("/**");		
		
		//CheckLoginInterceptor 등록 : 정보수정, 로그아웃
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserDataBean);
		
		InterceptorRegistration registration2 = registry.addInterceptor(checkLoginInterceptor);
		
		registration2.addPathPatterns("/user/modify", "/user/logout", "/board/*");// 인터셉서 통과하도록 유도
		registration2.excludePathPatterns("/board/main"); // 인터셉터 제외
		
	}
	
	// 두개의 서로다른 properties 설정이 충돌나지 않도록 합니다.
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	//메시지 등록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		
		res.setBasenames("/WEB-INF/properties/error_message");
		
		return res; 
	}	
	
	//스탠다드서블릿멀티파트리졸버 등록 (upload/download 용도)
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		
		return new StandardServletMultipartResolver();
		
	}
}












