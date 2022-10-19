package kr.co.ezen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.DataBean2;
import kr.co.ezen.beans.DataBean3;

@Configuration
public class RootAppContext {

	@Bean
	@SessionScope
	public DataBean dataBean() {
		return new DataBean();
	}
	
	@Bean("sessionBean2")
	@SessionScope 
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
	
	@Bean
	@SessionScope
	public DataBean3 dataBean3() {
		return new DataBean3();
	}
}
