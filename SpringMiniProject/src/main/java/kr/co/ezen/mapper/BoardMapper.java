package kr.co.ezen.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.ezen.beans.ContentDataBean;

// mapper : SQL작성에 집중하도록 도와줍니다.
// select, delete, update, insert 기능이 가능
// JDBC 연동에 비하여 95%이상의 코드가 감소하는 효과가 있다.
public interface BoardMapper {
	
	@Insert("insert into content_table(content_idx, content_subject, content_text, content_file, content_write_idx,"
			+ " content_board_idx, content_date)"
			+ " values(content_seq.nextval, #{content_subject}, #{content_text}, #{content_file}, "
			+ "#{content_write_idx}, #{content_board_idx}, sysdate)")
	
	void addContentInfo(ContentDataBean writeContentDataBean);
	
	@Select("select board_info_name from board_info_table where board_info_idx=#{board_info_idx}")
	String getBoardInfoName(int board_info_idx);

}
