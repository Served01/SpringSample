package kr.co.ezen.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1(Model model, Locale locale) {		
		
		String str1 = res.getMessage("aaa.a1", null, null); 
		String str2 = res.getMessage("bbb.b1", null, null); 
						
		Object[] argsObjects = {"홍길동", 999};
		
		String str3 = res.getMessage("aaa.a2", argsObjects, null); 
			
		System.out.println(locale);// ko, us
		System.out.println(str1);// 안녕하세요?
		System.out.println(str2);// 반갑습니다.
		System.out.println(str3);
		
		model.addAttribute("argsObject", argsObjects);
		
		return "test1";
	}
		
	
}