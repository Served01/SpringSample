<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>result16.jsp</h2>
	
	<h3>data3: ${requestScope.data3 }</h3>
	<h3>data4: ${requestScope.data4 }</h3>
	<h3>덧셈의 결과는 sum: ${requestScope.data3+requestScope.data4 }</h3>
	
</body>
</html>