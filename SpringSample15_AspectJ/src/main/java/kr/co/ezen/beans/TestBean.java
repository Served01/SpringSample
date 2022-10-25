package kr.co.ezen.beans;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

	public TestBean() {
		System.out.println("TestBean class의 생성자 입니다.~");
	}
	
	public void method1() {
		System.out.println("method1 Call...");
			
	}
	

	
}
