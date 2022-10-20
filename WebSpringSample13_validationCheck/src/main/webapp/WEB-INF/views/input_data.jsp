<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
</head>
<body>
	<h1>input_data</h1>
	<form action="input_pro" method="post">
		ID:<input type="text" name="id"/><br>
			<spring:hasBindErrors name="dataBean">
				<c:if test="${errors.hasFieldErrors('id')}">
					<strong>${errors.getFieldError('id').defaultMessage }</strong><br/>
				</c:if>
		  	</spring:hasBindErrors>
		Name:<input type="text" name="strname"/><br>
			<spring:hasBindErrors name="dataBean">
				<c:if test="${errors.hasFieldErrors('strname')}">
					<strong>${errors.getFieldError('strname').defaultMessage }</strong><br/>
				</c:if>
	 		</spring:hasBindErrors>
		Age:<input type="text" name="age"/><br>
			<spring:hasBindErrors name="dataBean">
				<c:if test="${errors.hasFieldErrors('age')}">
					<strong>${errors.getFieldError('age').defaultMessage }</strong><br/>
				</c:if>
	  		</spring:hasBindErrors>
			<button type="submit">확인</button>
	</form>
</body>
</html>