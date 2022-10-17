<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result3.jsp</h2>
	
	<% String data1 = request.getParameter("data1");
	String data2 = request.getParameter("data2");
	String data3 = request.getParameter("data3");
	
	if(data1==null){
		data1="0";
	} if(data2==null){
		data2="0";
	} if(data3==null){
		data3="0";
	}
	%>
	
	<% int data_1 = Integer.parseInt(data1);
	  int data_2 = Integer.parseInt(data2);
	  int data_3 = Integer.parseInt(data3);%>
	  
	<h3>data1: <%=data_1 %></h3>
	<h3>data2: <%=data_2 %></h3>
	<h3>data3: <%=data_3 %></h3>
	<h3>덧셈의 결과는 sum: <%=data_1+data_2+data_3 %></h3>
	
</body>
</html>