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
	<a href="test1?data1=100&data2=200">test1 get</a><br>
	<hr>
	<form action="test2" method="post">
		data1: <input type="text" name="data1"/> 
		data2: <input type="text" name="data2"/> 
	<button type="submit">test2 post</button>
	</form>
	<hr>
	<form action="test2_2" method="get">
	<input type="hidden" name="data1" value=300>
	<input type="hidden" name="data2" value=400>
	<button type="submit">test2_2 get</button>
	</form>
	<hr>
	<form action="test3" method="get">
	data1: 
	<input type="checkbox" name="data1" value="100" >100
	<input type="checkbox" name="data1" value="200" >200
	<input type="checkbox" name="data1" value="300" >300
	<input type="checkbox" name="data1" value="400" >400
	<br>
	data2: 
	<input type="checkbox" name="data2" value="100" >100
	<input type="checkbox" name="data2" value="200" >200
	<input type="checkbox" name="data2" value="300" >300
	<input type="checkbox" name="data2" value="400" >400
	<br>
	data3: 
	<input type="checkbox" name="data3" value="100" >100
	<input type="checkbox" name="data3" value="200" >200
	<input type="checkbox" name="data3" value="300" >300
	<input type="checkbox" name="data3" value="400" >400
	<br>
	<button type="submit">result3</button>
	</form>
	<hr>
	<a href="test4?data1=100&data2=200&data3=300&data4=400&data5=500">test4</a>
	
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