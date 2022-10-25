package kr.co.ezen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ezen.beans.BoardInfoBean;
import kr.co.ezen.mapper.TopMenuMapper;

//TopmenuMapper클래스의 getTopMenuList()를 호출하여 쿼리문을 실행하는 역할을 하는 
// 클래스인데, 이를 명시적으로 표현해 주는 부분.
@Repository
public class TopMenuDAO {
	
	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfoBean> getTopMenuList(){
		
		List<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();
		
		return topMenuList;
		
	}
	
}
