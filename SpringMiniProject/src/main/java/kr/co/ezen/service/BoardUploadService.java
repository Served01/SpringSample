package kr.co.ezen.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.ezen.beans.ContentDataBean;
import kr.co.ezen.beans.UserDataBean;
import kr.co.ezen.dao.BoardDAO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardUploadService {

	@Value("${path.upload}")
	private String path_upload;
	
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
	public List<ContentDataBean> getContentList(int board_info_idx){	  
	  return boardDAO.getContentList(board_info_idx); 	  
	}
	
	//
	 public ContentDataBean getContentInfo(int content_idx) {
		  
		  return boardDAO.getContentInfo(content_idx); 
	  }
	
	
}
