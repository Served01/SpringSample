package kr.co.ezen.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ezen.beans.DataBean;



@Controller
public class TestController {
	
	
	@GetMapping("/input_data")
	public String input_data(DataBean dataBean) {		
		
		
		
		return "input_data";
		
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean dataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			
			for(ObjectError objectError : result.getAllErrors()) {
				System.out.println(objectError.getDefaultMessage());
				System.out.println(objectError.getCode());
				System.out.println(objectError.getObjectName());
				
				String[] codeStrings = objectError.getCodes();
				
				for(String err1 : codeStrings) {
					System.out.println(err1);
				}
				
			if(codeStrings[0].equals("Size.dataBean.id")) {
				System.out.println("id는 8자이상 15자까지 입력할 수 있습니다.");
			} else if(codeStrings[0].equals("Size.dataBean.strname")) {
				System.out.println("name은 2자이상 30자까지 입력할 수 있습니다.");
			} else if(codeStrings[0].equals("Max.dataBean.age")) {
				System.out.println("age는 1~100 사이의 숫자로 입력할 수 있습니다.");
			}
			System.out.println("-------------------------------------------------");
			}
			return "input_data";
		}
		
		return "input_success";
	}
	
	
}