<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:url var='root' value='/'/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script type="text/javascript">
		alert("로그인을 실패 하였습니다.")
		location.href="${root}user/login?fail=true"
	</script>
</body>
</html>