package kr.co.ezen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import kr.co.ezen.beans.DataBean;

@Controller
public class TestController2 {
	
	@GetMapping(value = "/test1")
	public String test1(DataBean bean, Model model) {
			
		bean.setUserid_input("data2");
		bean.setUserid_output("data2");
		
		//String [] data_list1 = {"data1","data2","data3","data4","data5"};
		
		ArrayList<String> data_list2 = new ArrayList<String>();
		data_list2.add("data1");
		data_list2.add("data2");
		data_list2.add("data3");
		data_list2.add("data4");
		data_list2.add("data5");
		
						// objectname   value
		model.addAttribute("data_list2",data_list2);
		return "test1";
	}
	
	@PostMapping(value = "/result")
	public String result(@ModelAttribute("test") DataBean bean) {
		
		return "result";
	}
	
	
}
