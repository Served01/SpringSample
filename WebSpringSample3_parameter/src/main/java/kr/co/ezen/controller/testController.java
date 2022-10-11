package kr.co.ezen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		int data_1 = Integer.parseInt(data1);
		int data_2 = Integer.parseInt(data2);
		int sum = data_1 + data_2;
	
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data1 + data2: "+sum);
		return "result";//result.jsp
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String test2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		int data_1 = Integer.parseInt(data1);
		int data_2 = Integer.parseInt(data2);
		int sum = data_1 + data_2;
	
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data1 + data2: "+sum);
		return "result2";//result2.jsp
	}
	
	@RequestMapping(value = "/test2_2", method = RequestMethod.GET)
	public String test2_2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		int data_1 = Integer.parseInt(data1);
		int data_2 = Integer.parseInt(data2);
		int sum = data_1 + data_2;
	
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data1 + data2: "+sum);
		return "result2_2";//result2_2.jsp
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		int data_1 = Integer.parseInt(data1);
		int data_2 = Integer.parseInt(data2);
		int sum = data_1 + data_2;
	
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data1 + data2: "+sum);
		return "result3";//result3.jsp
	}
	
	
	
	
}