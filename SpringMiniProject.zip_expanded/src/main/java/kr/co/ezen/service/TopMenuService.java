package kr.co.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.beans.BoardInfoBean;
import kr.co.ezen.dao.TopMenuDAO;

@Service
//서비스는 DAO에 있는 메소드를 호출하여 받아온 정보를 가지고 필요한 처리를
//해주는 역할을 합니다.
//여기서는 TopMenuDAO의 getTopMenuList()를 호출하여 결과를 반환합니다.
public class TopMenuService {

	@Autowired
	private TopMenuDAO topMenuDAO;
	
	public List<BoardInfoBean> getTopMenuList(){
		
		List<BoardInfoBean> topMenuList = topMenuDAO.getTopMenuList();
		
		return topMenuList;
		
	}
	
	
}
