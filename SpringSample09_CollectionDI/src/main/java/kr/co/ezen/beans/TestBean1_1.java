package kr.co.ezen.beans;

public class TestBean1_1 {
	
	private int data1; //0=>0
	private double data2;//0.0=>0.0
	private String data3;//null=>null
	
	/*
	public TestBean() {
		//default Constructor
		System.out.println("기본 생성자입니다.~~~");
		
		this.data1 = 100;
		this.data2 = 100.0;
		this.data3 = "안녕하세요?";
		
	}
	*/
	//생성자 오버로딩
	public TestBean1_1(int x, double y, String z) {
		this.data1 = x;
		this.data2 = y;
		this.data3 = z;
	}
	
	
	public void printData() {
		
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data3: "+data3);
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
	
}
