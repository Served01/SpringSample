package kr.co.ezen.main;


import java.awt.geom.Point2D;
import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.TestBean;
/*
Setter Injection
--------------------------------------   
- 의존성을 입력 받는 setter 메소드를 만들고 이를 통하여 의존성을 주입합니다.
     
  1)Bean Factory : 
    Bean을 등록, 생성, 조회, 반환을 관리해 주는 역할을 합니다.
  	보통은 Bean Factory를 바로 사용하지 않고, 이를 확장한 Application Context를 사용합니다.
  	getBean()메소드가 정의되어 있음. 
   <종류>
	ApplicationEventPublisher, ListableBeanFactory, MessageSource, 
	ResourceLoader  ... 
  
  2)Application Context :
	Bean을 등록, 생성, 조회, 반환을 관리해주는 기능은 Bean Factory와 같습니다.
	Spring의 여러 가지 부가 서비스를 추가로 제공해 줍니다.
	Spring이 제공하는 부가 서비스를 구현한 클래스가 여러 종류 존재합니다.
	<종류>
	StaticApplicationContext, genericXmlApplicationContext, WebApplicationContext,
	XmlWebApplicationContext ...
	
  3)Setter 메소드를 통한 데이터 주입
    - Bean을 정의할 때, Bean 객체가 가지고 있을 기본 값을 생성자가 아닌 Setter 메소드를 이용하여 주입합니다.
	 
	//불변이고 고정적인 값
	 <bean id="dis" class="kr.co.OracleEducation.beans.TestBean">
	 	<property name="data1" value="100"/>  :  Setter
	 	<property name="data2" value="100.10"/>
	 	   .......
	 </bean>
	 
	 .name: 데이터 주입할 프로퍼티의 이름
	 .value: 기본 자료형(int, float, double, char, byte, short, long) 및 
		참조형 : reference형, 문자열(String)을 주입 할 때 사용하는 속성
	 .ref: 객체의 주소 값을 주입 할 때 사용하는 속성(보통 아무값이나 적습니다)
	 
 - 불변이고 고정적인 값을 설정: 
 
*/





public class mainClass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		/*Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		double y = scanner.nextDouble();
		boolean b = scanner.nextBoolean();
		String z = scanner.next();
		
		TestBean t1 = new TestBean();
		*/
		TestBean t1 = context.getBean("tb1", TestBean.class);
		/*System.out.println(t1);// address value = pointer value
		t1.setData1(x);
		t1.setData2(y);
		t1.setData3(b);
		t1.setData4(z);
		*/
		System.out.println(t1.getData1());//1500
		System.out.println(t1.getData2());
		System.out.println(t1.isData3());
		System.out.println(t1.getData4());
		
		
		context.close();
		
	}


}
