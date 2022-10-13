package kr.co.ezen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
			
		//                   objectName, String
		request.setAttribute("data1", "문자열입니다.");
		request.setAttribute("data2", "문자열입니다.2");
		
		return "forward:/result1";
		//return "redirect:/result1";
		//return "test1";
		
	}
	
	@GetMapping("/result1")
	public String result1() {
		return "result1";
	}

	@GetMapping("/test2")
	public String test2(Model model) {
			
		//                   objectName, String
		model.addAttribute("data3", "문자열입니다.3");
		model.addAttribute("data4", "문자열입니다.4");
		
		//return "forward:/result2"; //넘어오는 값이 존재하므로 출력이됩니다.
		//return "redirect:/result2"; //넘어오는 값이 없으므로 출력이 안됩니다.
		return "test2";
		
	}
	
	@GetMapping("/result2")
	public String result2() {
		return "result2";
	}
	
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView maView) {
			
		//                   objectName, String
		maView.addObject("data5", "문자열입니다.5");
		maView.addObject("data6", "문자열입니다.6");
		
		maView.setViewName("forward:/result3");
		
		return maView;
		//return "forward:/result3"; //넘어오는 값이 존재하므로 출력이됩니다.
		//return "redirect:/result3"; //넘어오는 값이 없으므로 출력이 안됩니다.
		//return "test3";
		
	}
	
	@GetMapping("/result3")
	public String result3() {
		return "result3";
	}
}
