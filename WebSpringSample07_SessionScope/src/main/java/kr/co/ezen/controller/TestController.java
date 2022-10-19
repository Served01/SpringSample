package kr.co.ezen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import kr.co.ezen.beans.DataBean;

@Controller
@SessionAttributes({"sessionBean", "sessionBean2"}) 
public class TestController {

	@ModelAttribute("sessionBean")
	public DataBean sessionBean() {
		return new DataBean();
	}
	

	@ModelAttribute("sessionBean2")
	public DataBean sessionBean2() {
		return new DataBean();
	}
	
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.setAttribute("data1", "문자열1");
		session.setAttribute("data2", "문자열2");
		
		//request.setAttribute("data1", "1.문자열 입니다.");
		//request.setAttribute("data2", "2.문자열 입니다.");
				
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		//Session area에 저장합니다.
		String data1 = (String) session.getAttribute("data1");
		String data2 = (String) session.getAttribute("data2");
		System.out.println(data1);
		System.out.println(data2);
		
		return "result1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		
		session.setAttribute("data3", "문자열3");
		session.setAttribute("data4", "문자열4");
						
		return "test2";
	}
	
	@GetMapping("/result2")
	public String result2(HttpSession session) {
			
		//Session area에 저장합니다.
		String data3 = (String) session.getAttribute("data3");
		String data4 = (String) session.getAttribute("data4");
		System.out.println(data3);
		System.out.println(data4);
		
		return "result2";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		DataBean bean = new DataBean();
		
		bean.setData1("문자열5");
		bean.setData2("문자열6");
		bean.setData3(25000);
						
		session.setAttribute("hyun", bean);
		
		return "test3";
	}
	
	@GetMapping("/result3")
	public String result3(@SessionAttribute("hyun") DataBean bean) {
	//public String result3(@SessionAttribute DataBean bean) {
	//public String result3(HttpSession session) {

		//session area에 저장
		//DataBean bean = (DataBean) session.getAttribute("bean");
				
		//System.out.println(bean.getData1()); 
		
		return "result3";
	}
	
	@GetMapping("/test4")
	public String test4(@ModelAttribute("sessionBean") DataBean sessionBean,
						@ModelAttribute("sessionBean2") DataBean sessionBean2) {
				
		sessionBean.setData1("문자열7");
		sessionBean.setData2("문자열8");
		sessionBean.setData3(45000);
		
		sessionBean2.setData1("문자열9");
		sessionBean2.setData2("문자열10");
		sessionBean2.setData3(35000);
										
		return "test4";
	}
	
	@GetMapping("/result4")
	public String result4(@ModelAttribute("sessionBean") DataBean sessionBean,
						  @ModelAttribute("sessionBean2") DataBean sessionBean2) {
			
		return "result4";
	}
	
}