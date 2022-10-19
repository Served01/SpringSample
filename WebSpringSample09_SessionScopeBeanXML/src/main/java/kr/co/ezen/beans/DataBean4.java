package kr.co.ezen.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component(value = "sessionBean4") //byName형식으로 처리
@SessionScope
public class DataBean4 {
	
	private String data10;
	private String data11;
	private int data12;
	
	public String getData10() {
		return data10;
	}
	public void setData10(String data10) {
		this.data10 = data10;
	}
	public String getData11() {
		return data11;
	}
	public void setData11(String data11) {
		this.data11 = data11;
	}
	public int getData12() {
		return data12;
	}
	public void setData12(int data12) {
		this.data12 = data12;
	}
	
	
	
	
	
}
