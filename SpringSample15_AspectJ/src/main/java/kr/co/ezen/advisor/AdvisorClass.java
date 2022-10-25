package kr.co.ezen.advisor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component  //advisor를 빈으로 등록하기 위하여 
public class AdvisorClass {

	@Before("execution(* method1())") 
	public void beforeMethod() {
		System.out.println("beforeMethod() Call...");  
	}
	
	@After("execution(* method1())") 
	public void afterMethod() {
		System.out.println("afterMethod() Call...");  
	}
	
	
}
