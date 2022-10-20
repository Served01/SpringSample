package kr.co.ezen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.DataBean2;


@Controller
public class TestController {
	
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/input_data")
	public String input_data() {		
		
		return "input_data";
		
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean dataBean, BindingResult result) {
		
		dataBean.getId();
		dataBean.getStrname();
		dataBean.getAge();
		
		//System.out.println(result);
		
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
	
	
	
	
		@GetMapping("/input_data2")
		public String input_data2(DataBean2 dataBean2) {		
		
		return "input_data2";
		
		}
	
		@PostMapping("/input_pro2")
		public String input_data2(@Valid DataBean2 dataBean2, BindingResult result) {
			
			dataBean2.getPostcode();
			dataBean2.getAddress1();
			dataBean2.getAddress2();
			
		for(ObjectError objectError : result.getAllErrors()) {
			String[] codeStrings = objectError.getCodes();
			
			for(String err1 : codeStrings) {
				System.out.println(err1);
			}
			
		if(codeStrings[0].equals("Size.dataBean2.postcode")) {
			System.out.println("postcode는 최대 5자리까지 입력 가능");
		} else if(codeStrings[0].equals("Size.dataBean2.address1")) {
			System.out.println("address1은 최소 3자리에서 최대 6자리까지 가능");
		} else if(codeStrings[0].equals("Max.dataBean2.address2")) {
			System.out.println("address2는 최소 3자리에서 최대 30자리까지 가능");
		}
		System.out.println("-------------------------------------------------");
		
			return "input_data2";
					
		}
		return "input_success2";
}
}