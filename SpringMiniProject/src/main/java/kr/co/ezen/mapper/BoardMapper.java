package kr.co.ezen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.ezen.beans.ContentDataBean;

// mapper : SQL작성에 집중하도록 도와줍니다.
// select, delete, update, insert 기능이 가능
// JDBC 연동에 비하여 95%이상의 코드가 감소하는 효과가 있다.
public interface BoardMapper {
	
	@SelectKey(statement = "select content_seq.nextval from dual", keyProperty = "content_idx", 
			before=true, resultType=int.class)
	@Insert("insert into content_table(content_idx, content_subject, content_text, content_file, content_write_idx," 
			+ "content_board_idx, content_date) "
			+ "values(#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, "
			+ "#{content_write_idx}, #{content_board_idx}, sysdate)")
	 void addContentInfo(ContentDataBean writeContentDataBean);	
	     	
	@Select("select board_info_name from board_info_table where board_info_idx = #{board_info_idx}")
		String getBoardInfoName(int board_info_idx);
	
	// 저자이름, 작성날짜, 내용, 이미지 등을 추출하여 가져와 내림차순 정렬하여 출력 합니다.	
	@Select("select c.content_idx, c.content_subject, u.user_name as content_writer_name, " +
			 "to_char(c.content_date, 'YYYY-MM-DD') as content_date " +
			 "from content_table c, user_table u " +
			 "where  c.content_write_idx = u.user_idx " +
			 "and c.content_board_idx = #{board_info_idx} " +
			 "order by c.content_idx desc")	
		List<ContentDataBean> getContentList(int board_info_idx, RowBounds rowBounds); 
	
	// 저자이름, 작성날짜, 내용, 이미지 등을 추출하여 가져와야 합니다.	
	@Select("select  u1.user_name as content_writer_name, " +
			 "to_char(c1.content_date, 'YYYY-MM-DD') as content_date, " +
			 "c1.content_subject, c1.content_text, c1.content_file, c1.content_write_idx " +        
			 "from content_table c1, user_table u1 " +
			 "where  c1.content_write_idx = u1.user_idx " +
		//	 "and c1.content_board_idx = #{board_info_idx} " +
			 "and c1.content_idx = #{content_idx}")	
		ContentDataBean getContentInfo(int content_idx);
	
	@Update("update content_table set content_subject = #{content_subject}, content_text = #{content_text}, " +
			"content_file = #{content_file, jdbcType=VARCHAR} " +
		//	"content_file = #{content_file } " +
			"where content_idx = #{content_idx}")
		void modifyContentInfo(ContentDataBean modifyContentDataBean);
	
	@Delete("delete from content_table where content_idx = #{content_idx}")
		void deleteContentInfo(int content_idx);
	
	@Select("select count(*) from content_table where content_board_idx = #{content_board_idx}")
		int getContentCnt(int content_board_idx);
	
	
}

/*메시지 Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: 
 * nested exception is org.apache.ibatis.type.TypeException: 
 * Could not set parameters for mapping: 
 * ParameterMapping{property='content_file', mode=IN, javaType=class java.lang.String, jdbcType=null, 
 * numericScale=null, resultMapId='null', jdbcTypeName='null', expression='null'}. Cause: 
 * org.apache.ibatis.type.TypeException: Error setting null for parameter #4 with JdbcType OTHER . 
 * Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. Cause: 
 * java.sql.SQLException: 부적합한 열 유형: 1111
 * 
 * => #{content_file, jdbcType=VARCHAR}, " 21번 라인에 이렇게 추가해 줍니다.
 */