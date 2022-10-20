package kr.co.ezen.beans;

import javax.validation.constraints.Size;

public class DataBean2 {
	
	
	@Size(max=5) //최대 5자리까지 입력 가능
	private String postcode;
	
	@Size(min=3, max=6) //주소1은 최소 3자리, 최대 6자리까지 가능
	private String address1;
	
	@Size(min=3, max=30) //주소2는 최소 3자리, 최대 30자리까지 가능
	private String address2;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	
	
	
	
}
