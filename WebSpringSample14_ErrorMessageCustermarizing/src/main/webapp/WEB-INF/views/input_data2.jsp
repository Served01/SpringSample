<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
</head>
<body>
	<h1>input_data2</h1>
	
	<form:form action="input_pro2" method="post" modelAttribute="dataBean2">
		ID:<input type="text" name="id"/><br>
		Name:<input type="text" name="strname"/><br>
		Age:<input type="text" name="age"/><br>
		<button type="submit">확인</button>
	</form:form>
	
	
</body>
</html>