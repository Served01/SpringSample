package kr.co.ezen.beans;

public class TestBean5 {
	
	public TestBean5() {
		System.out.println("생성자5 입입니다~");
	}
	
	public void testBean4_init() {
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
	
}
