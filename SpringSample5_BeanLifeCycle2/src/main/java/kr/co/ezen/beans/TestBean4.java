package kr.co.ezen.beans;

public class TestBean4 {
	
	public TestBean4() {
		System.out.println("생성자3 입입니다~");
	}
	
	public void default_init() {
		System.out.println("생성자 호출 이후에 자동으로 호출됩니다.");
		
	}
	
	public int Adder(int x, int y) {
		int sum = x + y;
		
		return sum;
	}
	
	public int multi(int x, int y) {
		int multi = x * y;
		
		return multi;
	}
	
	public double divi(double x, double y) {
		double divi = x / y;
		
		return divi;
	}
	
	public void default_destroy() {
		System.out.println("프로그램이 종료됩니다. 바이바이!!!");
		
	}
	
}
