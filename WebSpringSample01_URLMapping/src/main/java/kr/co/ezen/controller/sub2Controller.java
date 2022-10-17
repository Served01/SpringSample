package kr.co.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sub2")
public class sub2Controller {

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String test5() {
		System.out.println("/sub2/test5");
		return "sub2/test5";// sub2/test5.jsp
	}

	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String test6() {
		System.out.println("/sub2/test6");
		return "sub2/test6";// sub2/test6.jsp
	}
}
