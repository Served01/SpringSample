<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<c:url var='root' value='/'/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<!-- 게시글 리스트 -->
<div class="container" style="margin-top:100px">
	<div class="card shadow">
		<div class="card-body">
			<h4 class="card-title">${boardInfoName }</h4>
			<table class="table table-hover" id='board_list'>
				<thead>
					<tr>
						<th class="text-center d-none d-md-table-cell">글번호</th>
						<th class="w-50">제목</th>
						<th class="text-center d-none d-md-table-cell">작성자</th>
						<th class="text-center d-none d-md-table-cell">작성날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="str" items="${contentlist }">
					<tr>
						<td class="text-center d-none d-md-table-cell">${str.content_idx }</td>
						
						<!-- 어느게시판인가? 1:자바게시판, 2:JSP게시판, 3:spring게시판, 4:프로젝트게시판, 
										board_info_idx=${board_info_idx}
							특정 게시판에 몇번째 글인가?	content_idx=${str.content_idx}	
							
							http://localhost:8800/SpringMiniProject/board/read?board_info_idx=4&content_idx=5			
						 -->
						<td><a href='${root }board/read?board_info_idx=${board_info_idx}&content_idx=${str.content_idx}&page=${page}'>${str.content_subject }</a></td>
						<td class="text-center d-none d-md-table-cell">${str.content_writer_name }</td>
						<td class="text-center d-none d-md-table-cell">${str.content_date }</td>						
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="d-none d-md-block">
				<ul class="pagination justify-content-center">
					<c:choose>
						<c:when test="${pageCountBean.prevPage <= 0 }">
							<li class="page-item disabled">
								<a href="#" class="page-link">이전</a>
							</li>
						</c:when>
					<c:otherwise>
						<li class="page-item">
						<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${pageCountBean.prevPage}" class="page-link">이전</a>
						</li>					
					</c:otherwise>					
					</c:choose>
														
					<c:forEach var="idx" begin="${pageCountBean.min }" end="${pageCountBean.max }">
						<c:choose>
							<c:when test="$idx == pageCountBean.currentPage">
							<li class="page-item active">
								<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${idx}" class="page-link">${idx}</a>
							</li>		
						</c:when>
						
						<c:otherwise>
							<li class="page-item">
								<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${idx}" class="page-link">${idx}</a>
							</li>						
						</c:otherwise>						
						</c:choose>									
					</c:forEach>					
					
					<c:choose>
						<c:when test="${pageCountBean.max >= pageCountBean.pageCnt}">
							<li class="page-item disabled">
								<a href="#" class="page-link">다음</a>
							</li>
						</c:when>
					
					<c:otherwise>
						<li class="page-item">
							<a href="${root}board/main?board_info_idx=${board_info_idx}&page=${pageCountBean.nextPage}" class="page-link">다음</a>
						</li>
					</c:otherwise>
					</c:choose>
				</ul>
			</div>
			
					
			<!-- 어느게시판인가? 1:자바게시판, 2:JSP게시판, 3:spring게시판, 4:프로젝트게시판, 
										board_info_idx=${board_info_idx}
			-->
			<div class="text-right">
				<a href="${root}board/write?board_info_idx=${board_info_idx}" class="btn btn-primary">글쓰기</a>
			</div>
			
		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/include/footer_menu.jsp"/>

</body>
</html>






