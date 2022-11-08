package kr.co.ezen.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.mapper.BoardMapper;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper boardMapper;
	
	  public void addContentInfo(ContentDataBean writeContentDataBean) {			  
		 
		  boardMapper.addContentInfo(writeContentDataBean);		  		 
	  }	
	  
	  //
	  public String getBoardInfoName(int board_info_idx) {		  
		  return boardMapper.getBoardInfoName(board_info_idx); 		  
	  }
	
	  //
	  public List<ContentDataBean> getContentList(int board_info_idx, RowBounds rowBounds){		   
		  return boardMapper.getContentList(board_info_idx, rowBounds); 		  
	  }
	  
	  //
	  public ContentDataBean getContentInfo(int content_idx) {
		  
		  return boardMapper.getContentInfo(content_idx); 
	  }
	  
	  //글 수정 
	  public void modifyContentInfo(ContentDataBean modifyContentDataBean) {
		  
		  boardMapper.modifyContentInfo(modifyContentDataBean); 
	  }
	  
	  //글 삭제, BoardDAO
	 public void deleteContentInfo(int content_idx) {
		  
		 boardMapper.deleteContentInfo(content_idx); 
	  }
	  
	 //어느 게시판인가?
	 public int getContentCnt(int content_board_idx) {
		return boardMapper.getContentCnt(content_board_idx); 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
