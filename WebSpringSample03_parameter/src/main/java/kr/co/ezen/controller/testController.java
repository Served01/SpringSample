package kr.co.ezen.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.DataBean2;
import kr.co.ezen.beans.DataBean3;

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
		String data3 = request.getParameter("data3");
		
		if(data1==null) {
			data1="0";
		} if(data2==null) {
			data2="0";
		} if(data3==null) {
			data3="0";
		}
		
		int data_1 = Integer.parseInt(data1);
		int data_2 = Integer.parseInt(data2);
		int data_3 = Integer.parseInt(data3);
		int sum = data_1 + data_2 + data_3;
	
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data3: "+data3);
		System.out.println("data1 + data2 + data3: "+sum);
		return "result3";//result3.jsp
	}
	
	@GetMapping(value = "/test4")
	public String test4(WebRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String data3 = request.getParameter("data3");
		String data4 = request.getParameter("data4");
		String data5 = request.getParameter("data5");
		
		int data_1 = Integer.parseInt(data1);
		int data_2 = Integer.parseInt(data2);
		int data_3 = Integer.parseInt(data3);
		int data_4 = Integer.parseInt(data4);
		int data_5 = Integer.parseInt(data5);
		
		int sum = data_1+data_2+data_3+data_4+data_5;
		
		System.out.println("data1~data5: "+sum);
		
		return "result4";//result4.jsp
	}
	
	@GetMapping("/test5/{data1}/{data2}/{data3}/{data4}/{data5}")
	public String test5(@PathVariable int data1,
					    @PathVariable int data2,
					    @PathVariable int data3,
					    @PathVariable int data4,
			 			@PathVariable int data5) {
		
		System.out.println("data1: "+data1);
		System.out.println("data2: "+data2);
		System.out.println("data3: "+data3);
		System.out.println("data4: "+data4);
		System.out.println("data5: "+data5);
		
		
		
		int sum= data1 + data2 + data3 + data4 + data5;
		System.out.println("덧셈의 합계: "+sum);
		
		return "result5";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int data3,
						@RequestParam int data4,
						@RequestParam int data5) {
		
		int sum= data1 + data2 + data3 + data4 + data5;
		System.out.println("덧셈의 합계: "+sum);	
		
	
	return "result6";//result6.jsp
	}
	
	@GetMapping("/test7")
	public String test7(@RequestParam(value="data1") int value1,
						@RequestParam(value="data2") int value2,
						@RequestParam(value="data3") int value3,
						@RequestParam(value="data4") int value4,
						@RequestParam(value="data5") int value5) {
		
		int sum= value1 + value2 + value3 + value4 + value5;
		System.out.println("덧셈의 합계: "+sum);	
		
	
	return "result7";//result7.jsp
	}
	
	@GetMapping("/test8")
	public String test8(@RequestParam String data1,
						@RequestParam String data2,
						@RequestParam String data3,
						@RequestParam(required=false) String data4,
						@RequestParam(required=false) String data5) {
		
		
		System.out.println("data1: "+data1);	
		System.out.println("data2: "+data2);	
		System.out.println("data3: "+data3);	
		System.out.println("data4: "+data4); //null
		System.out.println("data5: "+data5); //null	
	
	return "result7";//result7.jsp
	}
	
	@GetMapping("/test9")
	public String test9(@RequestParam String data1,
						@RequestParam String data2,
						@RequestParam String data3,
						@RequestParam(defaultValue = "0") int data4,
						@RequestParam(defaultValue = "0") int data5) {
		
		
		System.out.println("data1: "+data1);	
		System.out.println("data2: "+data2);	
		System.out.println("data3: "+data3);	
		System.out.println("data4: "+data4); //0
		System.out.println("data5: "+data5); //0	
	
	return "result7";//result7.jsp
	}
	
	@GetMapping("/test10")
	public String test10(@RequestParam String data1,
						@RequestParam String data2,
						@RequestParam String data3,
						@RequestParam(required = false) int data4,
						@RequestParam(defaultValue = "0") int data5) {
		
		
		System.out.println("data1: "+data1);	
		System.out.println("data2: "+data2);	
		System.out.println("data3: "+data3);	
		System.out.println("data4: "+data4); //0
		System.out.println("data5: "+data5); //0	
	
	return "result7";//result7.jsp
	}
	
	@GetMapping("/test11")
	public String test11(@RequestParam Map<String, String> map) {
			  
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data3 = map.get("data3");
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		
		return "result11";

		}
	@GetMapping("/test12")
	public String test12(@RequestParam Map<String, String> map,
									@RequestParam List<String> data2) {
			  
		
		
		for(String str : data2) {
		System.out.println(str);
		}
		
		return "result11";

		}
	
	
	@GetMapping("/test13")
	public String test13(@RequestParam Map<String, String> map,
						 @RequestParam List<String> data2) {
			  
		
		for(String str : data2) {
		System.out.println(str);
		
		}
		
		return "result11";

		}
	
	
	@GetMapping("/test14")
	//@ModelAtrribute는 생략이 가능하다.
	public String test14(@ModelAttribute DataBean bean1, @ModelAttribute DataBean2 bean2) {
		
		System.out.println(bean1.getData1());
		
		for(int str : bean1.getData2()) {
			System.out.println(str);
		}
		
		System.out.println(bean2.getData3());
		
		for(int str2 : bean2.getData4()) {
			System.out.println(str2);
		}
		
		return "result11";

		}
	
	
	@GetMapping("/test15")
	public String test15(HttpServletRequest request) {
	     request.setAttribute("data1", 100);
	     request.setAttribute("data2", 200);
	     return "result15";
	}
	
	
	@GetMapping("/test16")
	public String test16(Model model) {
	     model.addAttribute("data3", 300);
	     model.addAttribute("data4", 400);
	     return "result16";
	}
	
	
	@GetMapping("/test17")
	public ModelAndView test17(ModelAndView mav) {
	     mav.addObject("data5", 500);
	     mav.addObject("data6", 600);
	     mav.setViewName("result17");
	     return mav;
	}
	
	
	@GetMapping("/test18")
	public String test18(@ModelAttribute DataBean3 bean3) {
	     
		System.out.println("data1: "+bean3.getData1());
		System.out.println("data2: "+bean3.getData2());
	     return "result18";
	     
	}
	
	@PostMapping("/test19")
	public String test19(@ModelAttribute("hyunBean") DataBean3 bean3) {
	//public String test19(DataBean3 bean3) {
		System.out.println("data1: "+bean3.getData1());
		System.out.println("data2: "+bean3.getData2());
		
	    return "result18";
	     
	}
	
	
	
	
}