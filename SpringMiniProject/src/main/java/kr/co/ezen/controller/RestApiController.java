package kr.co.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ezen.service.UserService;

// html형태의 데이터가 아니라면 사용합니다. 아니라면 json으로 처리를 합니다.

@RestController
public class RestApiController {

	@Autowired
	UserService userSevice;
	
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String restApiControll(@PathVariable String user_id) {
		
		boolean chk = userSevice.checkUserIdExist(user_id);
		
		return chk + "";
		
	}
	
}
