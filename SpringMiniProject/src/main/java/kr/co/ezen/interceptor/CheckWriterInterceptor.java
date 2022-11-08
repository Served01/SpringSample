package kr.co.ezen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{	

	private UserDataBean loginUserBean;
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserDataBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	
	//로그인이 안되어 있으면 false(로그인 먼저 하라는 박스 표출시 사용), 로그인이 되어 있으면 true
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				
		//외부에서 그냥 치고 들어올 경우.
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		ContentDataBean currentContentBean = boardService.getContentInfo(content_idx);
		
		//기존 로그인 체크를 아래와 같이 변경. 확인 해 볼 것.
		if(currentContentBean.getContent_write_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_write");
			return false;	//비정상적으로 접근 한 경우.
		}		
		return true;
	}
}