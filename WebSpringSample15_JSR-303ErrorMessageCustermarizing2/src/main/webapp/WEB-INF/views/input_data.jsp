<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
</head>
<body>
	<h1>input_data</h1>
	
	<form:form action="input_pro" method="post" modelAttribute="dataBean">
	
		data1:<br>
		<form:radiobutton path="data1" value="true"></form:radiobutton>true<br>
		<form:radiobutton path="data1" value="false"></form:radiobutton>false<br>
		<form:errors path="data1"/><br>
		
		data2:<br>
		<form:radiobutton path="data2" value="true"></form:radiobutton>true<br>
		<form:radiobutton path="data2" value="false"></form:radiobutton>false<br>
		<form:errors path="data2"/><br>
		
		data3:<br>
		<form:input path="data3" ></form:input><br>
		<form:errors path="data3"/><br>
		
		data4:<br>
		<form:input path="data4" ></form:input><br>
		<form:errors path="data4"/><br>
		
		data5:<br>
		<form:checkbox path="data5" value="checkbox" ></form:checkbox><br>
		<form:errors path="data5"/><br>
		
		data6:<br>
		<form:checkbox path="data6" value="checkbox" ></form:checkbox><br>
		<form:errors path="data6"/><br>
		
		data7:<br>
		<form:input path="data7" ></form:input><br>
		<form:errors path="data7"/><br>
		
		data8:<br>
		<form:input path="data8" ></form:input><br>
		<form:errors path="data8"/><br>
		
		data9:<br>
		<form:input path="data9" ></form:input><br>
		<form:errors path="data9"/><br>
		
		<form:button type="submit">확인</form:button>
		
	</form:form>
	
</body>
</html>