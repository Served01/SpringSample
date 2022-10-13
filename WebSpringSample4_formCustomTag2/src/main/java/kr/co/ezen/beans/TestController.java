package kr.co.ezen.beans;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
	
	@GetMapping(value = "/test1")
	public String test1(DataBean bean, Model model) {
			
		bean.setUserid_input("data2");
		bean.setUserid_output("data2");
		
		String [] data_list1 = {"data1","data2","data3","data4","data5"};
		
						// objectname   value
		model.addAttribute("data_list1",data_list1);
		return "test1";
	}
	
	@PostMapping(value = "/result")
	public String result(@ModelAttribute("test") DataBean bean) {
		
		return "result";
	}
	
	
}
