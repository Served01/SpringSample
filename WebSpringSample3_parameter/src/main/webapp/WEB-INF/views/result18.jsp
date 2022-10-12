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
	
	<h3>data1: ${hyunBean.data1 }</h3>
	<h3>data2: ${requestScope.hyunBean.data2 }</h3>
	<h3>덧셈의 결과는 sum: ${hyunBean.data1+requestScope.hyunBean.data2 }</h3>
	<!-- dataBean3.data1, requestScope.dataBean3.data1은 가능하나 param.dataBean3.data1 형식은 불가
		param을 쓸거면 param.data1 이런식으로 해야함. -->
</body>
</html>