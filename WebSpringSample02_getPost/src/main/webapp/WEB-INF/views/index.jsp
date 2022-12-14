<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Spring MVC Java</h1>
	<img src="image/bmwmodel_205.png"/><br>
	<a href="test1">test1</a><br>
	<a href="test2">test2 post</a><br>
	<hr>
	<form action="test2" method="get">
		<a href="test2">test2 get</a><br>
		<button type="submit">test2 get</button>
	</form><br>
	<form action="test2" method="post">
		<a href="test2">test2 post</a><br>
		<button type="submit">test2 post</button>
	</form><br>
	<form action="test3" method="get">
		<a href="test3">test3 get</a><br>
		<button type="submit">test3 get</button>
	</form><br>
	<form action="test3" method="post">
		<a href="test3">test3 post</a><br>
		<button type="submit">test3 post</button>
	</form><br>
	<hr>
	<a href="test4">test4 get</a><br>
	<form action="test4" method="post">
		<button type="submit">test4 post</button>
	</form><br>
	
</body>
</html>

<!-- 

.요청 방식 지정하기

Spring MVC 는 요청 주소별로 메서드를 정의할 수도 있지만 같은 요청 주소에서 요청 방식에 따라 메서드를 정의할 수도 있습니다.
GET, POST, PUT, DELELTE, PATCH 에 대해 처리할 수 있습니다.

@RequestMapping
RequestMapping 어노테이션은 요청 주소 셋팅 뿐만 아니라 요청 방식도 설정할 수 있습니다.

@RequestMapping(value = "/test1", method = RequestMethod.GET)
public String test1() {
	return "test1";
}

요청 어노테이션

RequestMapping 대신 요청별로 제공되는 어노테이션을 사용할 수도 있습니다.
@GetMapping("/test4")
public String test4() {
	return "test4";
}

@PostMapping("/test5")
public String test5() {
	return "test5";
}


동시에 설정하기

RequestMapping은 요청 방식들을 동시에 설정할 수 있습니다.

@RequestMapping(value = "/test7", method = {RequestMethod.GET, RequestMethod.POST})
public String test7() {
	return "test7";
}

-->