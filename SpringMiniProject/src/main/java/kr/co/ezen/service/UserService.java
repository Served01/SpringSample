package kr.co.ezen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDataBean loginUserDataBean;
		
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDAO.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		}else {
			return false;		
		}			
	}
	
	public void addUserInfo(UserDataBean joinUserDataBean) {
		
		userDAO.addUserInfo(joinUserDataBean); 
	}
	//
	public void  getloginUserInfo(UserDataBean tempUserDataBean) {
		//              
		UserDataBean tempUserDataBean2 = userDAO.getloginUserInfo(tempUserDataBean);
		
		if(tempUserDataBean2 != null) {
			loginUserDataBean.setUser_idx(tempUserDataBean2.getUser_idx()); 
			loginUserDataBean.setUser_id(tempUserDataBean2.getUser_id()); 
			loginUserDataBean.setUser_pw(tempUserDataBean2.getUser_pw());
			loginUserDataBean.setUser_name(tempUserDataBean2.getUser_name()); 
			loginUserDataBean.setUserlogin(true);
		}		
	}
	
	//
	public UserDataBean getModifyUserInfo(UserDataBean modifyUserDataBean) {	
		UserDataBean tempModifyUserDataBean = userDAO.getModifyUserInfo(loginUserDataBean.getUser_idx());
		
		modifyUserDataBean.setUser_id(tempModifyUserDataBean.getUser_id());
		modifyUserDataBean.setUser_idx(tempModifyUserDataBean.getUser_idx());
		modifyUserDataBean.setUser_name(tempModifyUserDataBean.getUser_name()); 		
		
		return tempModifyUserDataBean; 		
	}
	
	// 비번 수정
	public void modifyUserInfo(UserDataBean modifyUserDataBean) {
		modifyUserDataBean.setUser_idx(loginUserDataBean.getUser_idx()); 
		
		userDAO.modifyUserInfo(modifyUserDataBean);
		
	}
	
}
