package kr.co.ezen.beans;

public class TestBean4 {

	// className으로 지정
	private int data1;
	private String data2;
	private double data3;
	private DataBean4 data4;
	private DataBean4 data5;
	
	// 생성자 작성
	public TestBean4(DataBean4 data4, DataBean4 data5) {
		this.data4 = data4;
		this.data5 = data5;		
	}
	// 매개변수가 없이 생성자를 주입하여 객체를 생성하는 경우
	public TestBean4(int data1, String data2, Double data3, DataBean4 data4, DataBean4 data5) {
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
		this.data5 = data5;		
	}
		
	
	public int getData1() {
		return data1;
	}
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public double getData3() {
		return data3;
	}
	public void setData3(double data3) {
		this.data3 = data3;
	}
	public DataBean4 getData4() {
		return data4;
	}
	public void setData4(DataBean4 data4) {
		this.data4 = data4;
	}
	public DataBean4 getData5() {
		return data5;
	}
	public void setData5(DataBean4 data5) {
		this.data5 = data5;
	}
	
		
}
