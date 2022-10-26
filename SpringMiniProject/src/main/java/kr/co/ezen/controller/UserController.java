package kr.co.ezen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.service.UserService;
import kr.co.ezen.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login(@ModelAttribute("loginUserDataBean") UserDataBean loginUserDataBean) {
		return "user/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid@ModelAttribute("loginUserDataBean") UserDataBean loginUserDataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getloginUserInfo(loginUserDataBean);
		
		if(loginUserDataBean.isUserlogin() == true) {
			return "user/login_success";
		} else {
		
		return "user/login";
	}
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
		
		userService.addUserInfo(joinUserDataBean);
		
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
	
	//password check routine
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator = new UserValidator();
		binder.addValidators(validator);
	}
	
	
	//
	
	
}
