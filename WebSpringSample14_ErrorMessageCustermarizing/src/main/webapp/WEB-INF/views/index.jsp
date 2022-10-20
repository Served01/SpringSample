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
	<a href="input_data">input_data</a><br>
	<a href="input_data2">input_data2</a><br>
	
	<!-- 
	ValidationCheck
---------------------------------------------------------
 - 유효성 검사
 1) 웹 애플리케이션에서 사용자 입력에 대해 유효성을 검사해야 하는 경우가 있습니다.
 2) JavaScript로 처리할 수도 있지만 Spring MVC를 이용하여 처리할 수도 있습니다.

 - JSR-303
 1) Spring MVC는 JSR-303 규격의 유효성 검사 라이브러리를 사용할 수 있습니다.
 2) Bean에 데이터가 입력될 때 어떤 검사를 할 것인지 어노테이션으로 지정하고 
    지정된 어노테이션의 조건에 맞지 않으면 개발자에게 입력값에 오류가 있다는 정보를 전달합니다.
 3) 개발자는 이를 통해 유효성 검사를 진행할 수 있습니다.

  pom.xml
 JSR-303을 사용하려면 라이브러리를 추가해야 합니다. 
 JSR-303은 실제 유효성 검사를 할 클래스가 존재해야 하는데 
 여기서는 hibernate라는 라이브러리를 사용하겠습니다.

 <dependency>
   <groupId>javax.validation</groupId>
   <artifactId>validation-api</artifactId>
   <version>2.0.1.Final</version>
 </dependency>

 <dependency>
   <groupId>org.hibernate.validator</groupId>
   <artifactId>hibernate-validator</artifactId>
   <version>6.1.2.Final</version>
 </dependency>

 - Bean에 어노테이션 설정
  먼저 Bean에 어노테이션을 설정합니다. 
  JSR-303과 Hibernate에서는 다양한 어노테이션을 제공하고 있습니다.

  @Size(min = 2, max = 10)
   private String data1;

  @Max(100)
   private int data2;

 - @Valid
  1) Controller의 메서드에서 주입 받는 Bean에 @Valid를 설정하면 유효성 검사를 실시합니다.
  2) 유효성 검사 결과를 사용하고자 한다면 BindingResult 객체를 주입받아야 합니다.
  3) 이 객체에는 유효성 검사를 실행한 결과 정보가 담겨있습니다.
     이를 통해 Controller 에서 사용자가 입력한 값에 문제가 있는지 파악할 수 있습니다.

   @Valid
    public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {

    }

 - JSP에서 사용하기
  1) 만약 JSP에서 잘못 입력한 항목에 대해 메시지를 보여주고 싶다면 errors 를 사용하면 됩니다.
  2) Controller에서 주입 받았던 BidingResult 객체는 errors라는 이름으로 reques영역에 저장됩니다. 
     이를 이용해 메시지를 출력할 수 있습니다.

  <spring:hasBindErrors name="dataBean1">
	<c:if test="${errors.hasFieldErrors('data1')}">
		<strong>${errors.getFieldError('data1').defaultMessage }</strong><br/>
	</c:if>
  </spring:hasBindErrors>


.ErrorMessageCustermarizing
-----------------------------------------
 - 에러 메시지
  1)  유효성 검사에서 오류가 있다고 판단되는 항목에 대해서 JSP에서 메시지를 출력하였습니다.
  2) 우리가 출력한 메시지는 JSR-303에서 정의한 메시지가 그대로 나오는 것이며 
     우리가 설정한 문자열은 아닙니다.
  3) JSR-303과 Hibernate에서 제공하는 어노테이션중 일부는 새로운 메시지를 셋팅할 수 있고 
     일부는 셋팅하지 못합니다.

 - Properties를 이용한 메시지 설정
 1) 유효성 검사를 통과하지 못하면 JSP에 오류 관련된 정보가 전달됩니다. 
 2) 이때 codes[0]으로 값을 가져오면 다음 양식으로 문자열을 가져올 수 있습니다.
	에러종류.빈이름.프로퍼티이름

 3)우리가 Properties 파일에 위와 같은 양식의 이름으로 메시지를 등록해주면 
    Properties 파일에 작성한 문자열을 가져와 출력할 수 있고 다국어 처리까지 가능해집니다.

   Size.dataBean.id = 문자열 길이는 8~15글자 입니다
   Size.dataBean.strname = 문자열 길이는 2~30글자 입니다
   Max.dataBean.age = 값을 1~100 사이로 입력해주세요

   <spring:message code="${errors.getFieldError('data1').codes[0]}"/>

 - Form 데이터 유지하기
  1) 유효성 검증에 통과하지 못해 다시 입력 화면으로 돌아왔을 때 
      기존에 입력했던 내용을 유지해야 할 경우가 있습니다.
      이 때 입력 화면으로 전달된 Bean 객체에서 input 태그에 값을 주입하면 됩니다.
  2) 전에 살펴 보았던 Spring MVC의 Form 커스텀 태그를 활용하면 됩니다.
      이 때, 검증 실패 문자열도 손쉽게 셋팅하는 것이 가능합니다.

 * Properties 파일을 활용하면 에러 메시지를 설정할 수 있습니다.


.JSR-303
---------------------
 - JSR-303
 1) JSR-303 어노테이션은 빈 객체에 주입되는 값의 유효성 검사를 하기 위해 제공되는 어노테이션입니다.
    여기에서는 자주 사용하는 것만 골라서 보도록 하겠습니다.
 2) https://beanvalidation.org/1.0/spec/

	@AssertTrue : true가 아닌 값이 들어오면 오류
	@AssertFalse : false가 아닌 값이 들어오면 오류
	@Max(값) : 값보다 큰 값이 들어오면 오류
	@Min(값) : 값보다 작은 값이 들어오면 오류

 3) @DecimalMax(value=값, inclusive=true/false) : 값보다 작거나 같은 값이 들어와야 합니다. 
    Inclusive가 false면 값은 포함하지 않기 때문에 작은 값이 들어와야 합니다. 생략하면 true

 4) @DecimalMin(value=값, inclusive=true/false) : 값보다 크거나 같은 값이 들어와야 합니다. 
    Inclusive가 false면 값은 포함하지 않기 때문에 큰 값이 들어와야 합니다. 생략하면 true

 5) @Null : 값이 들어오면 오류가 발생.
    @NotNull : 값이 들어오지 않으면 오류가 발생.
    @Digits(integer=자릿수,fraction=자릿수) : 지정된 자릿수의 숫자가 아닐 경우 오류가 발생. 
         Integer – 정수 자릿수, fraction – 실수 자릿수
    @Size(min=글자수,max=글자수) : 지정된 글자수 보다 짧거나 길면 오류가 발생

  6) @Pattern(regexp=정규식) : 주어진 정규식에 위배되면 오류 발생

-->
  
	
</body>
</html>

