package kr.co.ezen.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean2 {

	public TestBean2() {
		System.out.println("TestBean2 class의 생성자 입니다.~");
	}
	
	@PostConstruct
	public void init() {
		int sum = 100 + 300;
		
		System.out.println("Adder : " + sum);
	}
	
	public void message() {
		System.out.println("여기는 중간 부분 입니다.~");
	}
	
	@PreDestroy
	public void destroy() {
		int sum = 100 * 300;
		
		System.out.println("Multi : " + sum);
	}
}
