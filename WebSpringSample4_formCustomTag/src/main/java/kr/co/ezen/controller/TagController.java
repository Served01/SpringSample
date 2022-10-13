package kr.co.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ezen.beans.DataBean;

@Controller
public class TagController {
	
	@GetMapping(value = "/test1")
	public String test1(DataBean bean, Model model) {
			
		String [] data_list1 = {"user_name", "user_id", "user_pw","user_postcode","user_address1","user_address2"};
		model.addAttribute("data_list1", data_list1);
		
		return "test1";
	}
	
	@PostMapping(value = "/result")
	public String result(@ModelAttribute("test") DataBean bean) {
		
//		bean.setUser_name("user_name");
//		bean.setUser_id("user_id");
//		bean.setUser_pw("user_pw");
//		bean.setUser_postcode("user_postcode");
//		bean.setUser_address1("user_address1");
//		bean.setUser_address2("user_address2");
		
		
		return "result";
	}
	
	
}
