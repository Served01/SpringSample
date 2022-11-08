package kr.co.ezen.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//사용자 정보 테이블 참조 
public class UserDataBean {

	private int user_idx; 
	
	@Size(min=2, max=30)
	@Pattern(regexp = "[a-zA-Z가-힣]*")
	private String user_name;
	
	@Size(min=8, max=15)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;
	
	@Size(min=8, max=15)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	
	@Size(min=8, max=15)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;
	
	private boolean userIdExist;
	
	private boolean userlogin;
	
	
	//생성자 주입
	public UserDataBean() {
		this.userIdExist = false;
		this.userlogin = false;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public boolean isUserlogin() {
		return userlogin;
	}

	public void setUserlogin(boolean userlogin) {
		this.userlogin = userlogin;
	}
	
	
	
}
