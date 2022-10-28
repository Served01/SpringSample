package kr.co.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.service.UserService;
import kr.co.ezen.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@SuppressWarnings("unused")
	@Autowired
	private UserDataBean joinUserDataBean;
	
	@Autowired
	private UserDataBean loginUserDataBean;
	
	@SuppressWarnings("unused")
	@Autowired
	private UserDataBean tempUserDataBean;
		
	@GetMapping("/login")
	public String login(@ModelAttribute("tempUserDataBean") UserDataBean tempUserDataBean,
						@RequestParam(value="fail", defaultValue = "false") boolean fail, Model model){
			
			model.addAttribute("fail", fail);

			//아직은 로그인하지 않았으므로 false로 설정
			//loginUserDataBean.setUserlogin(false);
			
			model.addAttribute("tempUserDataBean", tempUserDataBean);
			return "user/login";			
		}
			
	@PostMapping("/login_pro")
	public String login_pro(@Validated@ModelAttribute("tempUserDataBean") UserDataBean tempUserDataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
			
		userService.getloginUserInfo(tempUserDataBean);
		
		if(loginUserDataBean.isUserlogin() == true) {
			loginUserDataBean.setUserlogin(true);
			return "user/login_success";
		}else {
			loginUserDataBean.setUserlogin(false);
			return "user/login_fail";	
		}
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserDataBean") UserDataBean joinUserDataBean) {
		
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Validated@ModelAttribute("joinUserDataBean") UserDataBean joinUserDataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}			
		
		userService.addUserInfo(joinUserDataBean);
		
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserDataBean") UserDataBean modifyUserDataBean) {
		
		userService.getModifyUserInfo(modifyUserDataBean);
		
		return "user/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Validated@ModelAttribute("modifyUserDataBean") UserDataBean modifyUserDataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/modify";
		}			
		
		userService.modifyUserInfo(modifyUserDataBean);
		
		return "user/modify_success";
	}
	
	
	
	
	@GetMapping("/logout")
	public String logout() {
		
		loginUserDataBean.setUserlogin(false);   
	
		return "user/logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() {
			
		return "user/not_login";
	}
		
	//password check routine
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator = new UserValidator();
		binder.addValidators(validator); 
	}
	
	// 
	
	
	
}
