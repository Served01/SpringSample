package kr.co.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String test2_get() {
		System.out.println("test2");
		return "test2_get";//test1.jsp
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String test2_post() {
		System.out.println("test2");
		return "test2_post";//test1.jsp
	}
	
	
	@GetMapping(value = "/test3")
	public String test3_get() {
		System.out.println("test3");
		return "test3_get";//test3_get.jsp
	}
	
	@PostMapping(value = "/test3")
	public String test3_post() {
		System.out.println("test3");
		return "test3_post";//test3_post.jsp
	}
	
	@RequestMapping(value = "/test4", method = {RequestMethod.GET, RequestMethod.POST})
	public String test4() {
		return "test4";
	}


}
