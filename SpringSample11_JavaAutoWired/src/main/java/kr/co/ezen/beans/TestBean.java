package kr.co.ezen.beans;

public class TestBean {

	// className으로 지정	
	private int data1;
	private double data2;
	private String data3;
	private DataBean data4;
	
	//생성자 메소드
	public TestBean() {
				
	}
	
	
	public TestBean(int data1, double data2, String data3, DataBean data4) {
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;		
		this.data4 = data4;
	}	
	
	public int getData1() {
		return data1;
	}
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public double getData2() {
		return data2;
	}
	public void setData2(double data2) {
		this.data2 = data2;
	}
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}

	public DataBean getData4() {
		return data4;
	}

	public void setData4(DataBean data4) {
		this.data4 = data4;
	}
	
	
	
	
}
