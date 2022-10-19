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
	<a href="test1">test1 - SessionScope Test </a><br>
	<a href="result1">result1</a><br>
	<a href="test2">test2 - HttpSession Test </a><br>
	<a href="result2">result2</a><br>
	<a href="test3">test3 - HttpSession, DataBean Test </a><br>
	<a href="result3">result3</a><br>
	<a href="test4">test4 - HttpSession, DataBean, ModelAttribute, @SessionAttributes Test </a><br>
	<a href="result4">result4</a>
	
	<!-- 
	SessionScope
----------------------
 - Session
 1) 브라우저가 최초로 서버에 요청을 하게 되면 브라우저당 하나씩 메모리 공간을 서버에서 할당하게 됩니다.
 2) 이 메모리 영역은 브라우저당 하나씩 지정되며 요청이 새롭게 발생하더라도 같은 메모리 공간을 사용하게 됩니다. 
    이러한 공간을 session 이라고 부릅니다.
 3) 이 영역은 브라우저를 종료할 때 까지 서버에서 사용할 수 있습니다.

 - SessionScope
 1) 브라우저가 최초의 요청을 발생 시키고 브라우저를 닫을 때 까지를 SessionScope라고 부릅니다.
 2) SessionScope 에서는 session 영역에 저장되어 있는 데이터나 객체를 자유롭게 사용할 수 있습니다.

  @SessionAttribute
   1) Session 영역에 저장되어 있는 객체를 사용하고자 할 때 
   메서드의 매개변수로 @SessionAttribute를 설정하면 Session 영역에 저장되어 있는 Bean 을 주입 받을 수 있습니다.
    (DataBean1 : set/get)

  @SessionAttributes
   1) @ModelAttribute를 통해 주입 받는 Bean은 자동으로 Request 영역에 저장되고 Request 영역으로 부터 주입을 받게 됩니다.
   2) 이 때, @ModelAttribute를 통해 주입받는 Bean을 
   	@SessionAttributes로 지정해 놓이면 request 영역이 아닌 session 영역에 저장되고 
   	session 영역으로 부터 주입 받을 수 있습니다.
   3) 주의할 점은 @ModelAttribute를 활용하여 객체를 생성해 반환하는 메서드를 반드시 작성해 줘야 합니다.

  * session 영역에 데이터를 저장하게 되면 SessionScope 내에서 사용이 가능합니다.


.SessionScope 빈 주입
---------------------------
 - SessionScope
  1) Bean을 정의할 때 session scope로 정의하면 브라우저가 서버에 최초의 요청을 보낼 때 
     Bean 객체가 주입됩니다.
  2) 주입된 Bean은 주입만 이루어지는 것이므로 session 영역에 저장되지는 않습니다.
  3) Java 방식은 @SessionScope 를 사용합니다.
  4) XML 방식은 bean을 정의할 때 scope="session"으로 설정합니다.
	 -->
	
</body>
</html>

