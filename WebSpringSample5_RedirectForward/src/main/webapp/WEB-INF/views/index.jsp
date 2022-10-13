<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Spring MVC Java</h1>
	<img src="image/bmwmodel_205.png"/><br>
	
	<!-- form:option -->
	<a href="test1">test1 - Redirect </a><br>
	<a href="sub1">sub1 - Redirect </a><br>
	<a href="test2">test2 - forward </a><br>
	<a href="sub2">sub2 - forward </a>
	
	<!-- 
	Redirect와 Forward
------------------------------
 - 코드의 흐름
  1) 웹 애플리케이션은 브라우저가 서버에 요청을 하면 요청 정보를 분석하고 응답 결과를 생성하여 브라우저로 전달하는 과정을 거칩니다.
 2) 여기에서 서버의 동작은 어떤 분야를 가지고 개발을 하느냐에 따라 달라지게 됩니다.
 3) Spring MVC는 요청이 발생되면 요청 주소를 분석하여 그와 매핑되어 있는 메서드를 호출하고 메서드가 반환하는 정보를 토대로 
 	응답결과를 생성하여 클라이언트에게 전달합니다.

 - 메서드의 반환
  1) Controller를 통해 요청 주소와 매핑되어 있는 메서드는 반드시 무언가를 반환해야 합니다.
  2) 우리는 지금까지 문자열, Model, ModelAndView 를 반환해 보았습니다.
  3) 이들은 모두 브라우저에게 전달할 응답결과를 생성하기 위한 JSP를 지정하는 부분입니다.
  4) 이 밖에도 다양한 정보를 반환할 수 있으며 이를 토대로 동작을 제어할 수 있습니다.
     예] 에러 메시지 : properties

 - Redirect
  1) Redirect는 서버가 클라이언트에게 요청할 주소를 응답결과로 전달하는 것을 의미 합니다.
  2) 클라이언트는 응답결과로 받은 요청주소를 직접 요청하게 됩니다.
  3) 브라우저가 요청하는 것이므로 주소창의 주소는 변경됩니다.
  4) Redirect는 새로운 요청이 발생하는 것이므로 HttpServletRequest 객체는 소멸 후 새롭게 생성되며,
       HttpSession 객체는 그대로 유지됩니다.

 - forward
  1) 코드의 흐름을 서버상에서만 이동하는 것을 의미합니다.
  2) 브라우저는 다른 곳으로 흐름이 이동된다는 것을 알 수 없기 때문에 주소창의 주소는 변경되지 않습니다.
  3) HttpServletRequest, HttpSession 모두 유지됩니다.
		
	 -->
	
</body>
</html>

