package kr.co.ezen.service;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.beans.PageCountBean;
import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.dao.BoardDAO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;
	
	@Value("${page.listcnt}")
	private int page_listcnt;  
	
	@Value("${page.pagButtonCnt}")
	private int page_pageButtonCnt;
	
	@Autowired
	private BoardDAO boardDAO;	
	
	@Autowired
	private UserDataBean loginUserDataBean;
	
	@SuppressWarnings("unused")
	private String saveUploadfile(MultipartFile upload_file) {
		
		String file_name = upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file_name;
	}
	
	public void addContentInfo(ContentDataBean writeContentDataBean) {
		
		MultipartFile upload_file = writeContentDataBean.getUpload_file();
		
		if(upload_file.getSize() > 0) {			
			String file_name = saveUploadfile(upload_file);					
			writeContentDataBean.setContent_file(file_name); 			
		}
		
		//login 상태 체크하여 upload
		writeContentDataBean.setContent_write_idx(loginUserDataBean.getUser_idx()); 		
		boardDAO.addContentInfo(writeContentDataBean); 
	}
	
	//
	public String getBoardInfoName(int board_info_idx) {			
		  return boardDAO.getBoardInfoName(board_info_idx); 		  
	  }
	
	//
	public List<ContentDataBean> getContentList(int board_info_idx, int page){	  
		
		int start = (page -1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
	  return boardDAO.getContentList(board_info_idx, rowBounds); 	  
	}
	
	//
	 public ContentDataBean getContentInfo(int content_idx) { 
		  
		  return boardDAO.getContentInfo(content_idx); 
	  }
	
	 //글 수정
	  public void modifyContentInfo(ContentDataBean modifyContentDataBean) {
		  
		  MultipartFile upload_file = modifyContentDataBean.getUpload_file();
		  
		  if(upload_file.getSize() > 0) {
			  String file_name = saveUploadfile(upload_file);				
			  modifyContentDataBean.setContent_file(file_name); 
		  }
		  
		  boardDAO.modifyContentInfo(modifyContentDataBean); 
	  }
	  
	  //글 삭제, BoardService
		 public void deleteContentInfo(int content_idx) {			  
			 boardDAO.deleteContentInfo(content_idx); 
		  }
	
	//
	 public PageCountBean getContentCnt(int content_board_idx, int currentPage) {
	
		 int content_cnt = boardDAO.getContentCnt(content_board_idx);
		 
		//contentCnt: 전체글개수, currentPage: 현재글 번호, contentPageCnt: 페이지당 글 개수, pagButtonCnt: 페이지 버튼의 개수
		 PageCountBean pageCountBean = new PageCountBean(content_cnt, currentPage, page_listcnt, page_pageButtonCnt);
		 
		 return pageCountBean;
	 } 
		 
		 
		 
		 
}
