package kr.co.ezen.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

@SuppressWarnings("deprecation")
public class TestBean2 {

	// className으로 지정
	private int data1;
	private DataBean2 data2;
	
	public int getData1() {
		return data1;
	}
	
	@Required
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public DataBean2 getData2() {
		return data2;
	}
	
	@Autowired
	public void setData2(DataBean2 data2) {
		this.data2 = data2;
	}		
	
	
}
