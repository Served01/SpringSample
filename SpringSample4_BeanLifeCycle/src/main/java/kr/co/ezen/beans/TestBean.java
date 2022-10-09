package kr.co.ezen.beans;

public class TestBean {

	public TestBean() {
		System.out.println("생성자 입입니다~");
	}
	
	public int Adder(int x, int y) {
		int sum = x + y;
		
		return sum;
	}
	
}
