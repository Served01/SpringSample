package kr.co.ezen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.ezen.beans.UserDataBean;

@Configuration //root-context.xml 역할
public class RootAppContext {
	
	//login.jsp에서 다루는 데이터를 loginUserDataBean 객체에 저장할 예정 입니다.
	// 그리고, login.jsp에서 다룰 실제 빈은 tempUserDataBean이라고 설정하고 사용 예정입니다.
	  @Bean("loginUserDataBean")
	  @SessionScope //로그인 내용을 세션영역에 저장하기 위하여 사용
	  public UserDataBean loginUserDataBean() { 
		  return new UserDataBean(); 
	}
	 
}
