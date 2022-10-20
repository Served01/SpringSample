package kr.co.ezen.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class SpringConfigClass implements WebApplicationInitializer{
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		
//		// Spring MVC ������Ʈ ������ ���� �ۼ��ϴ� Ŭ������ ��ü�� �����Ѵ�.
//		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//		
//		// ��û �߻� �� ��û�� ó���ϴ� ������ DispatcherServlet���� �������ش�.
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//		
//		// �ΰ� ����
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//		
//		// Bean�� �����ϴ� Ŭ������ �����Ѵ�
//		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//		
//		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listener);
//		
//		// �Ķ���� ���ڵ� ����
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.addMappingForServletNames(null, false, "dispatcher");
//	}
//}

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletAppContext.class};
	}
	

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootAppContext.class};
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
}


















