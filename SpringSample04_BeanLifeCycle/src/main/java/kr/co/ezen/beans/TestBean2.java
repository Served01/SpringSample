package kr.co.ezen.beans;

public class TestBean2 {
	
	public TestBean2() {
		System.out.println("생성자2 입입니다~");
	}
	
	public int multi(int x, int y) {
		int multi = x * y;
		
		return multi;
	}
	
}
