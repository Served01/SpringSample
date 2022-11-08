<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var='root' value='/'/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script>
		alert("글쓰기를 성공 했습니다.")
		location.href="${root}board/read?board_info_idx=${writeContentDataBean.content_board_idx}&content_idx=${writeContentDataBean.content_idx}&page=${page}"
	</script>
</body>
</html>