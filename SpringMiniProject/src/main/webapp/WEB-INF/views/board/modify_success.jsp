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
		alert("글 수정을 성공 했습니다.")
		location.href="read?board_info_idx=${modifyContentDataBean.content_board_idx}&content_idx=${modifyContentDataBean.content_idx}&page=${page}"
	</script>
</body>
</html>