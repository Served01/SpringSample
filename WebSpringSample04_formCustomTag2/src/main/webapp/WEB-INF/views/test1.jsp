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
	
	 <form:form modelAttribute="dataBean" action="result">
	 	<form:select path="userid_input">
			<form:option value="data1">항목1</form:option><br>
			<form:option value="data2">항목2</form:option><br>
			<form:option value="data3">항목3</form:option><br>
			<form:option value="data4">항목4</form:option><br>
			<form:option value="data5">항목5</form:option><br>
		</form:select>
		<hr>
		<form:select path="userid_output">
			<form:options items= "${requestScope.data_list2 }"></form:options>
		</form:select>
		
	</form:form>
	 
	</body>
</html>