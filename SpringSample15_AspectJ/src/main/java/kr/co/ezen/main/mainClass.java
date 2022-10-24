package kr.co.ezen.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans2.TestBean3;

/* 
AOP(Aspect Oriented Programming)
----------------------------------------------
 - 관점(관심사) 지향적 프로그래밍
 - 하나의 프로그램을 관점이라는 논리적인 단위로 분리하여 관리하려는 개념
 - 주로 많이 사용되는 부분이 로깅, 선언적 트랜잭션, 보안, 캐싱 등  
 - 여기서 메소드 호출을 관심사로 두고 실습하는 것을 기준으로 하겠습니다.
 - <생각> 관심사를 통하여 스프링프레임워크가 어떤 메소드가 호출되는지 관심있게 지켜보다가 
   특정 메소드가 호출되면, 자동으로 메소드 전과 후에 다른 메소드를 호출하도록 하는 것 입니다.
   
 - 용어
  1)Joint Point : 모듈이 삽입되어 동작하게 되는 특정 위치(예> 메소드 호출 등) : 기능 구현
  2)Point Cut : 다양한 Joint Point 중에서 어떤 것을 사용할 지 선택해야 합니다. : 현금관리 기능, 예외처리 기능
  3)Advice : Joint Point에 삽입되어서 동작할 수 있는 코드 : 프로그램 로직
  4)Weaving : Advice를 핵심 로직 코드에 적용하는 것 : 컴파일/실행
  5)Aspect : Point Cut + Advice
 
 -Advice 종류 
  1)before : 메소드 호출 전에 동작하는 Advice
  2)after : 예외 발생 여부에 관계없이 호출된 메소드의 동작이 완료되면 동작하는 Advice
  3)around : 메소드 호출 전과 후에 동작하는 Advice
  4)after-returning : 예외 없이 호출된 메소드의 동작이 완료되면 동작하는 Advice
  5)after-throwing : 호출된 메소드 동작 중 예외가 발생하였을 때 동작하는 Advice
 
	<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
	<dependency>
    	<groupId>org.aspectj</groupId>
    	<artifactId>aspectjweaver</artifactId>
    	<version>1.9.9.1</version>
    	<scope>runtime</scope>
	</dependency>

	<!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
	<dependency>
	    <groupId>javax.annotation</groupId>
	    <artifactId>javax.annotation-api</artifactId>
	    <version>1.3.2</version>
	</dependency>

 * 위의 두개의 dependency를 pom.xml에 추가해야 한다.

 -Spring AOP 구현
  1)XML 구현방법
  2)@AspectJ 어노테이션을 이용하여 구현 방법: java를 이용한 방식
 
 - method(  )의 유형
   1)원형 : 접근제한자,  반환값, 메소드명( int kor, int eng, int mat), 매개변수(전달인자)
           public   void  method1(                                        ) {
		System.out.println("method1의 호출.");		
	}

   2)메소드 오버로딩
     메소드 오버라이딩(상속: interface, class, abstract class) 
     @Override


	 Execution 명시자
----------------------------------------
 - 메소드 원형 : 접근제한자,  반환값, 메소드명( int kor, int eng, int mat), 매개변수(전달인자)

 - 사용 목적 : Pointcut을 지정할 때 사용

 - execution(접근제한자,  반환값(리턴타입), 클래스이름, 메소드명(매개변수(전달인자)) )

   1) 접근 제한자 : public만 지원합니다.
   2) 리턴타입 : 메소드의 매개변수 타입
   3) 클래스 이름 : 패키지를 포함한 클래스 이름
   4) 메소드 이름 : 메소드의 이름
   5) 매개변수 : 매개변수의 형태
     - ** : 하나의 모든 것을 이미한다.
     - .. : 개수에 상관없이 모든 것을 의미하다.

	<!--context-aop 설정-->
	<bean id='advisor1' class='kr.co.korea.advisor.AdvisorClass'/>
	<aop:config>
		<aop:aspect ref='advisor1'>
	<!-- 반환타입은 void, kr.co.korea.beans.TestBean1 클래스, method1 메소드, 매개변수 없음.-->
	<aop:pointcut id="point1" expression="execution(void kr.co.korea.beans.TestBean1.method1())"/>
	<aop:before method="firstMethod1" pointcut-ref="point1"/>
	<aop:pointcut id="point2" expression="execution(void kr.co.korea.beans.TestBean1.method2())"/>
	<aop:before method="secondMethod2" pointcut-ref="point2"/>
	<aop:pointcut id="point1" expression="execution(void kr.co.korea.beans.TestBean1.method1(int))"/>
	<aop:pointcut id="point1" expression="execution(void kr.co.korea.beans.TestBean1.method1(String))"/>
			
	<aop:pointcut id="sss1" expression="execution(void kr.co.korea.beans.TestBean1.method1(*))"/>
	<aop:after method="Method3" pointcut-ref="sss1"/>
	
	<aop:pointcut id="aaa1" expression="execution
					(int kr.co.korea.beans2.TestSample1.add(int x, int y))"/>
		<aop:after method="Method333" pointcut-ref="aaa1"/>
			
	<!-- 반환타입은 void, kr.co.korea.beans 패키지, TestBean1 클래스, method1 메소드, 정수형 매개변수 2개 존재. -->
	<aop:pointcut id="point1" expression=
		"execution(void kr.co.korea.beans.TestBean1.method1(int, int))"/>
			
	<aop:pointcut id="point1" expression=
		"execution(void kr.co.korea.beans.TestBean1.method1(int, String))"/>
			
	<aop:pointcut id="point1" expression=
		"execution(void kr.co.korea.beans.TestBean1.method1(String, int))"/>
				
	<aop:pointcut id="point1" expression=
		"execution(void kr.co.korea.beans.TestBean1.method1(String, String))"/>
				
   <!-- 반환타입은 void, kr.co.korea.beans 패키지, TestBean1 클래스, method1 메소드, 모든 타입의 매개변수 0개 이상. -->			<aop:pointcut id="point1" expression=
			"execution(void kr.co.korea.beans.TestBean1.method1(..))"/>
		
<!-- 반환타입은 void, kr.co.korea.beans 패키지, TestBean1 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->		
	<aop:pointcut id="point1" expression=
		"execution(void kr.co.korea.beans.TestBean1.*(..))"/>
				
	<!-- 반환타입은 void, kr.co.korea.beans 패키지, 모든 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->				<aop:pointcut id="point1" expression=
				"execution(void kr.co.korea.beans.*.*(..))"/>
				
	<!-- 반환타입은 void, kr.co.korea.beans 패키지, 모든 클래스, method1 메소드, 모든 타입의 매개변수 0개 이상. -->	
		<aop:pointcut id="point1" expression=
				"execution(void kr.co.korea.beans.*.method1(..))"/>
		
	<!-- 반환타입은 void, kr.co.korea. 모든 패키지, 모든 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->				<aop:pointcut id="point1" expression=
				"execution(void kr.co.korea.*.*.*(..))"/>
				
	<!-- 반환타입은 void, kr.co.korea. 모든 패키지, TestBean1 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->	
			<aop:pointcut id="point1" expression=
				"execution(void kr.co.korea.*.TestBean1.*(..))"/>
						
	<!-- 반환타입은 void, 모든 패키지, 모든 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->			
			<aop:pointcut id="point1" expression=	"execution(void *.*(..))"/>
		
	<!-- 반환타입은 int, 모든 패키지, 모든 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->			
			<aop:pointcut id="point1" expression=	"execution(int *.*(..))"/>	
		
	<!-- 모든 반환타입, 모든 패키지, 모든 클래스, 모든 메소드, 모든 타입의 매개변수 0개 이상. -->			
			<aop:pointcut id="point1" expression=	"execution(* *.*(..))"/>	
				
	<!--  모든 패키지 -->			
		<aop:pointcut id="point1" expression=	"execution(* *(..))"/>		
		
	<!--  모든 패키지의 method1인 경우에 -->			
		<aop:pointcut id="point1" expression=	"execution(* method1(..))"/>					
		
	<!-- AOP 적용시 다양한 상황에 대응 할 수 있는 명시자를 제공하고 있습니다. -->
		<!-- <aop:around method="aroundMethod" pointcut-ref="point1"/>
		<aop:after-returning method="afterReturningMethod" pointcut-ref="point1"/> -->
		
		</aop:aspect>
</aop:config> 





 */

public class mainClass {

	public static void main(String[] args) {
		//XML 방식
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean bean1 = context.getBean("xml1", TestBean.class);
		int sum = bean1.method1();
		System.out.println(sum); //1000
		
		int sum2 = bean1.method2();
		System.out.println(sum2); //3000
		
		bean1.method3(20);
		
		
		bean1.method4(20,"원 입니다.");
		
		
		bean1.method5(20, 100.123);
		
		TestBean2 bean2 = context.getBean("xml2", TestBean2.class);
		int sum3 = bean2.method2();
		System.out.println(sum3);
		
		TestBean3 bean3 = context.getBean("xml3", TestBean3.class);
		bean3.method3();
		
		context.close();
	}	
}
