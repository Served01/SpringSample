package kr.co.ezen.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
	
	public void beforeMethod() {
		
		System.out.println("beforeMethod Call...");
		
	}
	
	public void afterMethod() {
			
		System.out.println("afterMethod Call...");
			
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("aroundMethod Call...11");
		
		Object object = pjp.proceed();
		
		System.out.println("aroundMethod Call...12");
		
		return object;
		
	}
	
	public void afterReturningMethod() {
		
		System.out.println("afterReturningMethod Call...");
		System.out.println("...처리가 잘 되었습니다.");
	}
	
	public void afterThrowingMethod() {
		
		System.out.println("afterThrowingMethod Call...");
		System.out.println("...처리 중에 예외가 발생하였습니다.");
	}
}
