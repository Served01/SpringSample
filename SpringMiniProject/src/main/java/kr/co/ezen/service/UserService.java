package kr.co.ezen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name= userDAO.checkUserIdExist(user_id);
		
		if(user_name==null) {
			return true;
		}else {
		return false;
		}
	}
	
	
	public void addUserInfo(UserDataBean joinUserDataBean) {
		
		userDAO.addUserInfo(joinUserDataBean);
		
	}
	
	//
	public void getloginUserInfo(UserDataBean loginUserDataBean) {
		//                 id + pw
		UserDataBean loginUserDataBean2 = userDAO.getloginUserInfo(loginUserDataBean);
		
		if(loginUserDataBean2 != null) {
			
			loginUserDataBean.setUser_id(loginUserDataBean2.getUser_id());
			loginUserDataBean.setUser_pw(loginUserDataBean2.getUser_pw());
			
		}
	}
	
}
