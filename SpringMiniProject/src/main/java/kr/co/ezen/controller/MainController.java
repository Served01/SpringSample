package kr.co.ezen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezen.beans.BoardInfoBean;
import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.service.MainService;
import kr.co.ezen.service.TopMenuService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@SuppressWarnings("unused")
	@Autowired
	private TopMenuService topMenuService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		ArrayList<List<ContentDataBean>> list = new ArrayList<List<ContentDataBean>>();
		
		for(int i=1; i <=4; i++) {
			List<ContentDataBean> list2 = mainService.getMainList(i);
			list.add(list2);			
		}
		
		model.addAttribute("list", list);
		
		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);
				
		return "index";		
	}
	
}
