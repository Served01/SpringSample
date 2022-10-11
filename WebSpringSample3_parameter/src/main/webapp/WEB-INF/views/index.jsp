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
	<hr>
	<a href="test5/100/200/300/400/500">test5</a>
	<hr>
	<a href="test6?data1=100&data2=200&data3=300&data4=400&data5=500">test6</a>
	<hr>
	<a href="test7?data1=100&data2=200&data3=300&data4=400&data5=500">test7</a>
	<hr>
	<a href="test8?data1=100&data2=200&data3=300">test8</a>
	<hr>
	<a href="test9?data1=100&data2=200&data3=300">test9</a>
	<hr>
	<a href="test10?data1=100&data2=200&data3=300">test10</a>
	<hr>
	<a href="test11?data1=100&data2=200&data3=300">test11</a>
	<hr>
	<a href="test12?data1=100&data2=200&data2=300">test12</a>
	<hr>
	<a href="test13?data1=100&data2=200&data2=300&data2=400">test13</a>
	<hr>
	<a href="test14?data1=100&data2=200&data2=300&data2=400&data3=500&data4=600&data4=700">test14</a>
	
</body>
</html>

<!-- 
 Parameter 추출하기
-------------------------
클라이언트 요청 발생 시 전달하는 파라미터 데이터를 손쉽게 주입 받을 수 있도록 다양한 방식을 제공하고 있습니다.
Spring MVC는 Servlet/JSP 처럼 요청 방식에 따라 파라미터 추출하는 방식이 달라지지는 않습니다.

 - HttpServletRequest 사용하기
 1) Spring MVC는 필요한 객체나 데이터는 주입을 받아 사용하게 됩니다.
 2) Servlet/JSP에서 파라미터 데이터를 추출할 때 HttpServletRequest request 객체를 통하게 되는데 
    Spring MVC에서 이 객체를 주입 받아 사용할 수 있습니다.
 3) 파라미터 추출 뿐만 아니라 HttpServletRequest 객체가 필요할 경우 사용하면 됩니다.

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {

	String data1 = request.getParameter("data1");
	String data2 = request.getParameter("data2");
	String [] data3 = request.getParameterValues("data3");

				… 생략
	}


 - WebRequest 사용하기
   WebRequest는 HttpServletRequest 클래스를 확장한 클래스입니다.
 
  @GetMapping("/test3")
   public String test3(WebRequest request) {

   String data1 = request.getParameter("data1");
   String data2 = request.getParameter("data2");
   String [] data3 = request.getParameterValues("data3");

   				 …생략…
   }


 - @PathVariable
     데이터가 요청 주소에 있을 경우 값을 주입 받을 수 있는 어노테이션입니다.
   Restful API 서버 프로그래밍시 많이 사용하는 방식입니다.
            데이터1/2/3
      요청주소/값1/값2/값3

	형 변환
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1, 
					    @PathVariable int data2, 
			 			@PathVariable int data3) {
			 	.........
	}

- @RequestParam
	1) 파라미터 데이터를 직접 주입 받을 수 있습니다.
	2) 지정된 변수의 이름과 파라미터의 이름이 같을 경우 값을 주입 받습니다.
	3) 가능한 경우 형 변환도 처리해줍니다.
	4) value : 파라미터의 이름과 변수의 이름이 다를 경우 파라미터 이름을 지정합니다.
	5) required : false를 설정하면 지정된 이름의 파라미터가 없을 경우 null이 주입되고, 
		있으면 넘어온 값으로 됩니다.(문자인 경우)
	6) (defaultValue = "0")설정하면 기본값으로 설정되고,  있으면 넘어온 값으로 됩니다. 
		
	@GetMapping("/test7")
	public String test7(@RequestParam(value = "data1") String value1,
			  @RequestParam(value = "data2", required = false) String value2,
			  @RequestParam(value = "data3", defaultValue = "default") String value3) {
			  
			  ..........	
	 }

 - Map으로 주입 받기
 1) 클라이언트가 전달 하는 모든 파라미터 데이터를 한번에 Map으로 받을 수 있습니다. 
 2) 단, 동일 명으로 전달되는 2개 이상의 파라미터는 하나만 담기게 됩니다.
 3) 동일명으로 전달되는 파라미터가 2개 이상이라면 List로 주입 받아야 합니다.

  public String test1(@RequestParam Map<String, String> map, 
		  @RequestParam List<String> data3) {

	}

 - @ModelAttribute
  1) ModelAttribute 어노테이션을 사용하면 파라미터를 객체로 주입받을 수 있습니다.
  2) 전달되는 파라미터의 이름과 동일한 프로퍼티에 자동으로 주입됩니다.
  3) 이 어노테이션은 생략이 가능합니다. 이러한 객체를 커맨드 객체(Command Object)라고 부릅니다.

  public String test2(@ModelAttribute DataBean1 bean1, 
		      @ModelAttribute DataBean2 bean2) {

  }
  
  .ViewResolver
------------------
  - 컨트롤러에서 전달 받은 View의 이름을 토대로 jsp를 찾아 선택하고 jsp 데이터를 분석해 응답결과를 만들어 전달하는 요소 입니다.
본 과정에서는 ViewResolver가 사용할 View의 이름을 지정하는 방법과 jsp 를 통해 응답 결과를 만들 때 필요한 데이터를 전달하는 방법에 대해 살펴봅니다


 - HttpServletRequest
 - Spring MVC는 jsp 를 처리할 때 HttpServletRequest 객체를 jsp 쪽으로 전달합니다.
ViewResolver는 이를 이용해 JSP 작업시 데이터를 사용할 수 있습니다.

  public String test2(HttpServletRequest request) {
     request.setAttribute("value1", 100);
     request.setAttribute("value2", 200);
     return "test2";
}

 - Model
Model 객체를 주입 받아 셋팅하면 HttpServletRequest 객체에 담겨 이를 JSP로 전달할 수 있습니다.

public String test3(Model model) {
model.addAttribute("value3", 300);
model.addAttribute("value4", 400);
return "test3";
}

 - ModelAndView

ModelAndView는 Model에 값을 셋팅하는 기능과 View의 이름을 지정하는 기능을 모두 가지고 있습니다.
public ModelAndView test5(ModelAndView mv) {
mv.addObject("value3000", 3000);
mv.addObject("value4000", 4000);
mv.setViewName("test5");
return mv;
}

ViewResolver에 의해 JSP가 실행되고 응답결과가 만들어집니다.
Controller 에서 View를 지정할 때 ViewResolver가 사용할 데이터를 Request 영역에 저장할 수 있습니다.


.커맨드 객체
-------------------
 클라이언트가 전달해 주는 파라미터 데이터를 주입 받기 위해 사용하는 객체

 - Request를 통해 전달
@PostMapping("/test1")
public String test1(@ModelAttribute DataBean bean) {
	return "test1";
}

 
커맨드 객체는 HttpServletRequest 객체에 자동으로 담기고 jsp로 전달됩니다.
이 때, HttpServletRequest 객체에 저장되는 이름은 클래스의 이름으로 결정됩니다.
@PostMapping("/test1")
public String test1(@ModelAttribute DataBean bean) {
	return "test1";
}
 -->