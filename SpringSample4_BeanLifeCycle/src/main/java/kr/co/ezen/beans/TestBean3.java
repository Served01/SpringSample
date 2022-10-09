package kr.co.ezen.beans;

public class TestBean3 {
	
	public TestBean3() {
		System.out.println("생성자3 입입니다~");
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
	
}
