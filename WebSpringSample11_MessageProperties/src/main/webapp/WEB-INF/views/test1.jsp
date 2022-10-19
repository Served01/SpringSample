<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.jsp</h1>	
	<h2>messageProperties 테스트 결과</h2>
	<h2>aaa.a1: <spring:message code="aaa.a1"/></h2>
	<h2>bbb.b1: <spring:message code="bbb.b1"/></h2>
	<h2>aaa.a2: <spring:message code="aaa.a2" arguments="${argsObject }"/></h2> 
</body>
</html>