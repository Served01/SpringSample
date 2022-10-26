package kr.co.ezen.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.ezen.beans.UserDataBean;

public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserDataBean.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		UserDataBean userDataBean = (UserDataBean) target;
		
		if(userDataBean.getUser_pw().equals(userDataBean.getUser_pw2()) == false) {
			
			errors.rejectValue("user_pw", "NotEquals");
			errors.rejectValue("user_pw2", "NotEquals");
		}
		
		if(userDataBean.isUserIdExist() == false) {
			errors.rejectValue("user_id", "DontCheckUserIdExist");
		}
		
		
	}
	

}

/*

*/