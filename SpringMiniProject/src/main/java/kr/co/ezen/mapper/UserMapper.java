package kr.co.ezen.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.ezen.beans.UserDataBean;

public interface UserMapper {

	@Select("select user_name from user_table where user_id = #{user_id}")
		String checkUserIdExist(String user_id);
	
	@Insert("insert into user_table(user_idx, user_name, user_id, user_pw)"
			+ "values(user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
		void addUserInfo(UserDataBean joinUserDataBean);
		
	@Select("select * from USER_TABLE"
			+ "	where user_id=#{user_id} and user_pw = #{user_pw}")
	UserDataBean  getloginUserInfo(UserDataBean tempUserDataBean);
	
	@Select("select user_id, user_name from user_table where user_idx = #{user_idx}")
		UserDataBean getModifyUserInfo(int user_idx);
			
	@Update("update user_table set user_pw = #{user_pw} where user_idx = #{user_idx}")
		void modifyUserInfo(UserDataBean modifyUserDataBean);
		
	
}
