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
	
	public UserDataBean getloginUserInfo(UserDataBean loginUserDataBean) {
		
		return userMapper.getloginUserInfo(loginUserDataBean);
	}
	
}
