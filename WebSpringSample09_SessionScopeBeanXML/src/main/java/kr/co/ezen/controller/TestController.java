package kr.co.ezen.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.DataBean2;
import kr.co.ezen.beans.DataBean3;
import kr.co.ezen.beans.DataBean4;

@Controller
public class TestController {

	@Autowired // byType 형식으로 처리
	@Lazy
	DataBean sessionBean;
	
	@Resource(name = "sessionBean2") // byName 형식으로 처리
	@Lazy
	DataBean2 sessionBean2;	
	
	@Autowired // byType 형식으로 처리
	DataBean3 sessionBean3;	
	
	@Resource(name = "sessionBean4") // byName 형식으로 처리
	DataBean4 sessionBean4;	
	
	
	@GetMapping("/test1")
	public String test1() {		
		
		sessionBean.setData1("문자열1");
		sessionBean.setData2("문자열2");	
		sessionBean.setData3(1000);
		
		sessionBean2.setData4("문자열3");
		sessionBean2.setData5("문자열4");		
		sessionBean2.setData6(3000);
		
		sessionBean3.setData7("문자열5");
		sessionBean3.setData8("문자열6");	
		sessionBean3.setData9(4000);
		
		sessionBean4.setData10("문자열7");
		sessionBean4.setData11("문자열8");		
		sessionBean4.setData12(5000);
					
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		//request area에 저장합니다.
		model.addAttribute("sessionBean", sessionBean);
		model.addAttribute("sessionBean2", sessionBean2);
		model.addAttribute("sessionBean3", sessionBean3);
		model.addAttribute("sessionBean4", sessionBean4);
				
		return "result1";
	}
		
	
	
}