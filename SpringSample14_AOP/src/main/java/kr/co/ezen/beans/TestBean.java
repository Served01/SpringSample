package kr.co.ezen.beans;




public class TestBean {

	public TestBean() {
		
		System.out.println("TestBean class의 생성자 입니다.~");
		
	}
	
	
	public int method1() {
		
		System.out.println("method1 Call...");
		
		return 1000;
	}
	
	
	public int method2() {
		
		System.out.println("method2 Call...");
		
		return 3000;
	}
	
	
	public int method3(int x) {
		
		int sum= x*x;
		
		return sum;
		
	}
	
	public String method4(int x, String str) {
		
		String sum= x + str;
		
		return sum;
		
	}
	
	public void method5(int x, double y) {
		
		double sum= y / x;
		
		System.out.println(sum);
		
	}
}
