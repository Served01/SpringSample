<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="input_pro2" method="post" modelAttribute="dataBean2">
		우편번호 :<form:input path="postcode"/><br>
				<form:errors path="postcode"></form:errors><br>
		주소1: <form:input path="address1"/><br>
				<form:errors path="address1"></form:errors><br>
		주소2: <form:input path="address2"/><br>
				<form:errors path="address2"></form:errors><br>
		<form:button type="submit">확인</form:button>
	</form:form>
</body>
</html>