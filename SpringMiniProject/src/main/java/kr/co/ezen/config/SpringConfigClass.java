package kr.co.ezen.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


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
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		
		super.customizeRegistration(registration);
		
		//5MB 정도 이미지를 올릴 수 있다는 의미이다.
		MultipartConfigElement configElement = new MultipartConfigElement(null, 1024*1024*5, 1024*1024*5, 0);
		registration.setMultipartConfig(configElement);
		
	}
	
}


















