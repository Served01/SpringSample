package kr.co.ezen.beans;


public class TestBean {

	public TestBean() {
		System.out.println("TestBean class의 생성자 입니다.~");
	}
	
	public void init1() {
		System.out.println("TestBean class의 init().");
	}
	
	public void destroy1() {
		System.out.println("TestBean class의 destroy().");
	}
	
}
