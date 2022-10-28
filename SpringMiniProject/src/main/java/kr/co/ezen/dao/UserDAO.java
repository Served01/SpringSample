package kr.co.ezen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.mapper.UserMapper;

@Repository
public class UserDAO {
	
	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id){
				
		return userMapper.checkUserIdExist(user_id);		
	}
	
	public void addUserInfo(UserDataBean joinUserDataBean) {
		
		userMapper.addUserInfo(joinUserDataBean); 
	}
	//로그인 정보
	public UserDataBean  getloginUserInfo(UserDataBean tempUserDataBean) {
		
		return userMapper.getloginUserInfo(tempUserDataBean);
	}
	
	// 수정 할 정보
	public UserDataBean getModifyUserInfo(int user_idx) {				
		return userMapper.getModifyUserInfo(user_idx); 		
	}
	
	// 비번 수정
	public void modifyUserInfo(UserDataBean modifyUserDataBean) {
		userMapper.modifyUserInfo(modifyUserDataBean);
		
	}
	
}
