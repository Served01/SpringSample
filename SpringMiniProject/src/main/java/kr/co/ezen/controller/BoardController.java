package kr.co.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.beans.PageCountBean;
import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	/* @GetMapping("/main")
	 * @ : Annotation 을 이용한다는 것은 비지니스 로직에만 개발자가 전념하도록 유도하는 것 입니다.
	 *  기존에는 객체 관리를 개발자가 했는데, 그런데 스프링에서는 스프링프레임워크에서 객체를 생성하고 관리 합니다.
	 */
	
	@SuppressWarnings("unused")
	@Autowired
	private BoardService boardService;	
	
	@Autowired
	private UserDataBean loginUserDataBean;
	
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
						@RequestParam(value = "page", defaultValue = "1") int page,
						Model model) {
		
		//ModelAndView 개념
		model.addAttribute("board_info_idx", board_info_idx);
		
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);		
		model.addAttribute("boardInfoName", boardInfoName);
		
		List<ContentDataBean> contentlist =  boardService.getContentList(board_info_idx, page);		
		model.addAttribute("contentlist", contentlist);
		
		PageCountBean pageCountBean = boardService.getContentCnt(board_info_idx, page);
		model.addAttribute("pageCountBean", pageCountBean);
		
		model.addAttribute("page", page);
		
		return "board/main";
	}
	
	@GetMapping("/read")
	public String read(@RequestParam("board_info_idx") int board_info_idx,
						@RequestParam("content_idx") int content_idx, 
						@RequestParam("page") int page,
						Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		ContentDataBean readContentDataBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentDataBean", readContentDataBean);
		//login한 사람의 인덱스 번호
		model.addAttribute("loginUserDataBean", loginUserDataBean);
		model.addAttribute("page", page);
		
		return "board/read";
	}
	
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentDataBean") ContentDataBean writeContentDataBean,
						@RequestParam("board_info_idx") int board_info_idx) {
		
		// 어떤 게시판이냐?
		writeContentDataBean.setContent_board_idx(board_info_idx);		
		
		return "board/write";
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@Validated@ModelAttribute("writeContentDataBean") ContentDataBean writeContentDataBean, 
																				BindingResult result,
																				@RequestParam("page") int page,
																				Model model) {
		
		if(result.hasErrors()) {
			return "board/write";
		}
		// upload 처리 
		boardService.addContentInfo(writeContentDataBean);
		model.addAttribute("page", page);
		
		return "board/write_success";
	}
	
	@GetMapping("/not_write")
	public String not_write() {
		return "board/not_write";
	}
	
	
	@GetMapping("/modify")
	public String modify(@RequestParam("board_info_idx") int board_info_idx,
						@RequestParam("content_idx") int content_idx, 
						@ModelAttribute("modifyContentDataBean") ContentDataBean modifyContentDataBean,
						@RequestParam("page") int page,
						Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		modifyContentDataBean = boardService.getContentInfo(content_idx);
		model.addAttribute("modifyContentDataBean", modifyContentDataBean);
		
		model.addAttribute("loginUserDataBean", loginUserDataBean);
		model.addAttribute("page", page);
		
		//게시들 내용 수정 모드로 불러오기
		ContentDataBean tempContentDataBean = boardService.getContentInfo(content_idx);
		
		modifyContentDataBean.setContent_writer_name(tempContentDataBean.getContent_writer_name());
		modifyContentDataBean.setContent_date(tempContentDataBean.getContent_date());
		modifyContentDataBean.setContent_subject(tempContentDataBean.getContent_subject());
		modifyContentDataBean.setContent_text(tempContentDataBean.getContent_text());
		modifyContentDataBean.setContent_file(tempContentDataBean.getContent_file());
		modifyContentDataBean.setContent_write_idx(tempContentDataBean.getContent_write_idx());
		
		//modifyContentDataBean.setContent_board_idx(tempContentDataBean.getContent_board_idx());
		//modifyContentDataBean.setContent_idx(tempContentDataBean.getContent_idx());	

		//idx가 0인 오류는 아래처럼 해줍니다.
		modifyContentDataBean.setContent_board_idx(board_info_idx);
		modifyContentDataBean.setContent_idx(content_idx);	
		
		return "board/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Validated@ModelAttribute("modifyContentDataBean") ContentDataBean modifyContentDataBean, 
																				BindingResult result,
																				@RequestParam("page") int page,
																				Model model) {	
		model.addAttribute("page", page);
		
		if(result.hasErrors()) {
			return "board/modify";
		}
		// upload 처리 
		boardService.modifyContentInfo(modifyContentDataBean);
		
		return "board/modify_success";
	}
		
	
	@GetMapping("/delete")
	public String delete(@RequestParam("board_info_idx") int board_info_idx,
						@RequestParam("content_idx") int content_idx,
						Model model) {
		
		boardService.deleteContentInfo(content_idx);
		
		model.addAttribute("board_info_idx", board_info_idx);
				
		return "board/delete";
	}
	
	
	
	
	
	
	
	
	
	
}
