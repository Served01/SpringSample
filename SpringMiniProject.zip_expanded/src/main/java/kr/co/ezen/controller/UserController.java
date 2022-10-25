package kr.co.ezen.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ezen.beans.UserDataBean;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserDataBean") UserDataBean joinUserDataBean) {
		
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid@ModelAttribute("joinUserDataBean") UserDataBean joinUserDataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}	
		
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
}
