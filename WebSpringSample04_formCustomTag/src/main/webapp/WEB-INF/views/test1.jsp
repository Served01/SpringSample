<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1.jsp</title>
</head>
<body>
	<h2>test1</h2>
	<!-- 
	<form action="result" method="post">
		이름: <input type="text" name="user_name" value=" ${ test.user_name }"><br>
		아이디: <input type="text" name="user_id" value="${ test.user_id }"><br>
		비번: <input type="text" name="user_pw" value="${ test.user_pw}"><br>
		우편번호 : <input type="text" name="user_postcode" value="${ test.user_postcode}"><br>
		주소1 : <input type="text" name="user_address1" value="${ test.user_address1}"><br>
		주소2 : <input type="text" name="user_address2" value="${ test.user_address2}"><br>
		<button type="submit">전송확인</button>
	</form>
	 -->
	 <form:form modelAttribute="dataBean" action="result" method="post">
		이름: <form:hidden  path="user_name"/><br>
		아이디: <form:select  path="user_id"/><br>
		비번1: <form:input  path="user_pw" type="password"/><br>
		비번2: <form:password  path="user_pw" /><br>
		우편번호 : <form:input  path="user_postcode"/><br>
		주소1 : <form:input  path="user_address1"/><br>
		주소2 : <form:textarea  path="user_address2"/><br>
		
		<form:button>전송확인</form:button>
		<form:button disabled="true">전송확인</form:button>
	</form:form>
	 
	</body>
</html>