<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>result18.jsp</h2>
	
	<h3>data1: ${requestScope.data1 }</h3>
	<h3>data2: ${requestScope.data2 }</h3>
	<h3>덧셈의 결과는 sum: ${requestScope.data1+requestScope.data2 }</h3>
	
</body>
</html>