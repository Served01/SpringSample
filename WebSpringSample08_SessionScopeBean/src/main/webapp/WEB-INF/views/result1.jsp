<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result1.jsp</h2>
	<h3> data1 : ${requestScope.sessionBean.data1 }</h3>
	<h3> data2 : ${requestScope.sessionBean.data2 }</h3>
	<h3> data3 : ${requestScope.sessionBean.data3 }</h3>
	
	<h3> data4 : ${requestScope.sessionBean2.data4 }</h3>
	<h3> data5 : ${requestScope.sessionBean2.data5 }</h3>
	<h3> data6 : ${requestScope.sessionBean2.data6 }</h3>
	
	<h3> data7 : ${requestScope.sessionBean3.data7 }</h3>
	<h3> data8 : ${requestScope.sessionBean3.data8 }</h3>
	<h3> data9 : ${requestScope.sessionBean3.data9 }</h3>
	
	<h3> data10 : ${requestScope.sessionBean4.data10 }</h3>
	<h3> data11 : ${requestScope.sessionBean4.data11 }</h3>
	<h3> data12 : ${requestScope.sessionBean4.data12 }</h3>
</body>
</html>