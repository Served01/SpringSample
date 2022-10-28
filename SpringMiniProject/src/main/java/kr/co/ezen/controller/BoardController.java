package kr.co.ezen.controller;

import org.apache.bval.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.service.BoardUploadService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	/* @GetMapping("/main")
	 * : 일단 이렇게 하는 일차적 이유는 mvc2에서 무조건 이런 형태로 하라고 하기 때문이다.
	 * @: Annotation을 이용한다는 것은 비지니스 로직에만 개발자가 전념하도록 유도하는 것이다.
	 *  기존에는 객체 관리를 개발자가 했는데, 그런데 스프링에서는 스프링프레임워크에서 객체를 생성하고 관리한다.
	 * 
	 */
	
	@Autowired
	private BoardUploadService boardUploadService;

	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx, Model model) {
		
		//ModelAndView 개념
		model.addAttribute("board_info_idx", board_info_idx);
		
		String boardInfoName = boardUploadService.getBoardInfoName(board_info_idx);
		
		model.addAttribute("boardInfoName", boardInfoName);
		
		return "board/main";
	}
	
	@GetMapping("/read")
	public String read() {
		return "board/read";
	}
	
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentDataBean") ContentDataBean writeContentDataBean,
			@RequestParam("board_info_idx") int board_info_idx) {
		
		//어떤 게시판이냐?
		writeContentDataBean.setContent_board_idx(board_info_idx);
		
		return "board/write";
	
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@Validate@ModelAttribute("writeContentDataBean") ContentDataBean writeContentDataBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/write";
		}
		
		//upload 처리
		boardUploadService.addContentInfo(writeContentDataBean);
		
		return "board/write_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}
}
