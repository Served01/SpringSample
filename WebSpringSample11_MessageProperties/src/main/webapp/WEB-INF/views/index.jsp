<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<a href="test1">test1 - messageProperties Test </a><br>
	
	
	<!-- 
	Properties
---------------------
 - 애플리케이션을 개발할 때 프로그램 실행 중 절대 변하지 않는 값들이 있을 수 있습니다.
 - Spring MVC에서는 이러한 값들을 properties 파일에 작성하고 이를 가져다 사용할 수 있도록 제공되고 있습니다.

 - Property Editor
  1) Properties 파일에 한글을 작성하면 유니코드 형식의 문자열로 변경됩니다.
     이는 Property Editor 설치로 해결할 수 있습니다.
  2) http://propedit.sourceforge.jp/eclipse/updates

 - @PropertySource, @PropertySources
  1) 사용할 properties 파일을 지정합니다.
  2) 하나 혹은 다수의 파일을 지정할 수 있습니다.

  @Controller
  @PropertySource("/WEB-INF/properties/data1.properties")
  @PropertySource("/WEB-INF/properties/data2.properties")
	public class TestController {
			.........
	}

  @Controller
  @PropertySources({
	@PropertySource("/WEB-INF/properties/data1.properties"),
	@PropertySource("/WEB-INF/properties/data2.properties")
   })
	public class TestController {
			.........
	}
	
  @Controller
  @PropertySource(value = {
	("/WEB-INF/properties/data1.properties"),
	("/WEB-INF/properties/data2.properties")
   })	
 	public class TestController {
			.........
		}
		
 - @Value
   properties 파일에 작성한 값을 주입 받을 수 있습니다.

   @Value("${aaa.a1}")
    private int a1;

   @Value("${aaa.a2}")
    private String a2;

.Message  
------------------------------------------------
 - Properties
  1) 이전 시간에 살펴본 Properties를 활용하면 다양한 값들을 미리 정의 해놓고 
     이를 Spring MVC에서는 가져다 사용할 수 있습니다.
  2) Properties에 작성한 값을 JSP에서 사용하고자 한다면 몇 가지 설정이 필요합니다.

 - Message
  1) Properties 파일을 Message로 등록하면 이 데이터는 JSP에서도 사용할 수 있습니다.
  2) Properties 파일을 Message로 등록하면 다국어 처리가 가능해집니다.

 - MessageSource
  1) MessageSource 객체를 이용해 properties 파일을 등록해주면 Message로 등록할 수 있습니다. 
  2) 여기에서는 일정 시간마다 한번씩 갱신되는 ReloadableResourceBundleMessageSource를 사용합니다.

 - Java에서 사용하기
  1) Message로 등록된 데이터를 Java 코드에서 사용하고자 한다면 
     MessageSource를 주입 받아 사용하면 됩니다.
  2) 이 때, Locale을 지정하면 다국어 처리가 가능합니다.
  3) @Autowired
	ReloadableResourceBundleMessageSource res;

 - JSP에서 사용하기
 1) Message로 등록된 데이터를 JSP에서 사용하고자 한다면 message 커스텀 태그를 사용합니다.
 2) <h3>a1 : <spring:message code="aaa.a1"/></h3>

 * Properties 파일을 Message로 등록하게 되면 JSP에서도 사용할 수 있으며 다국어 처리도 가능해 집니다.

-->
  
	
</body>
</html>

