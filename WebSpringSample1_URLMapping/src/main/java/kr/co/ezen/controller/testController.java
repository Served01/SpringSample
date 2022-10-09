package kr.co.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		System.out.println("test1");
		return "test1";//test1.jsp
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		System.out.println("test2");
		return "test2";//test2.jsp
	}
}
