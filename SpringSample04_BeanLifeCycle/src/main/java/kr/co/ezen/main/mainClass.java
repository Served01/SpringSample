package kr.co.ezen.main;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;


/* 자바 빈 : 데이터를 표현하는 것을 목적으로 하는 자바클래스(클래스에 값을 저장하는 속성필드, get, set 메소드, rlqhstodtjdwk vhgka)
 * 
 * 스프링 빈 : 스프링 IoC 컨테이너가 관리하는 객체
 * 
 * [장점]
 * - 의존성관리 : 스코프 관리
 * 	1)singleton(기본) 방식: default, 주소가 항상 똑같다.
 * 	2)prototype 방식: 요청할 때마다 새로운 객체를 생성
 * 	3)request: http 요청별로 인스턴스화되어 요청이 끝나면 소멸(Spring MVC 용도)
 *  4)session: http 세션별로 인스턴스화되어 요청이 끝나면 소멸(Spring MVC 용도)
 *  5)global session: 포틀릿 기반의 웹 애플리케이션 용도,
 *  	전역세션 스코프의 빈은 같은 스프링 MVC를 사용한 포탈 애플리케이션 내의 모든 포틀릿 사이에 공유가 가능합니다.
 *  6)thread: 새 스레드에서 요청하며 새로운 bean 인스턴스를 생성, 같은 스레드에소는 항상 같은 bean을 반환합니다.
 *  7)cutom: org.springframework.beans.factory.confing.Scope를 구현하고
 *  	커스텀 스코프를 스프링의 설정에 등록하여 사용
 *  
 * .Bean Life Cycle : 라이프 사이클 인터페이스
 * -------------------------------------------------------------------------------------------
 * 	객체 생성 -> 의존설정 -> 초기화 -> 소멸
 * - 사용할 객체를 bean configuration file에 정의를 하고 필요할 때 객체를 가져와서 사용하는 방법을 이용합니다.
 * - bean 태그: <bean> ~~~ </bean> : 사용할 bean을 정의하는 태그
 * - 기본속성
 * 	1)id: Bean 객체를 가져오기 위해 사용하는 이름을 지정한다.
 * 	2)class: 객체를 생성하기 위하여 사용할 클래스를 지정한다.
 * 	3)lazy-init: singleton인 경우에는 xml을 로딩할 때 객체 생성 여부를 설정한다.
 * 		true 옵션인 경우에는 xml로딩 시에 객체를 생성하지 않고, 객체를 가져올 때(getBean) 생성합니다.
 * 	4)scope: 객체의 범위를 지정합니다.
 * 		singleton: 객체를 하나만 생성하여 사용합니다. (객체의 재사용성)
 * 		prototype: 객체를 호출 할 때마다 객체를 생성합니다. (항상 서로다른 주소값을 가지고 처리)
 * 
 * <!-- xml을 로딩할 때 자동으로 객체가 생성됩니다. -->
 * 		<!-- <bean class="kr.co.korea.beans.beans.TestBean"/> -->
 * 
 * 		<!-- id속성을 주면 getBean()을 이용하여 객체의 주소값을 받아 사용할 수 있는데, singleton이다. -->
 * 		<baen id='test1' class="kr.co.korea.beans.TestBean"/>
 * 
 *    	<!-- xml을 로딩할 때 객체가 생성되지 않고, id속성을 주면 getBean()을 이용하여 객체의 주소값을 받아 사용할 수 있는데, 객체는 하나만 생성되는 singletin이다 -->
 *    	<bean id = 'test2' class = "kr.co.korea.beans.TestBean" lazy-init = "true"/>
 *    
 *    	<!-- xml을 로딩 할 때 객체가 생성되지 않고, id속성을 주면 getBean()을 이용하여 메소드를 호출 할 때마다 새로운 객체의 주소값을 생성하여 반환할 수 있다 -->
 *      <bean id = 'test3' class = "kr.co.korea.beans.TestBean" scope = "prototype"/>
 * 
 * - 객체 생성과 소멸시에 호출되는 메소드 등록
 * 	1)객체가 생성되면 가장먼저 생성자가 호출된다.
 * 	2)init-method : 생성자 호출 이후에 자동으로 호출됩니다.
 * 	3)destroy-method : 객체가 소멸할 때 자동으로 호출됩니다.
 * 	4)default-init-method : init-method를 설정하지 않으면 자동으로 호출됩니다.
 * 	5)default-destroy-method : destroy-method가 설정되어있지 않은 경우에 자동으로 호출됩니다.
 * 
 * <!-- 객체가 생성될 때 생성자가 호출된 이후에 init-method에 설정한 메소드가 자동으로 호출되고,
 * 		IoC 컨테이너의 close 메소드가 호출되면 객체가 소멸되며, destroy-method에 설정한 메소드가 자동으로 호출된다. -->
 * 		<bean id='td' class="kr.co.korea.beans.TestBean2"
 * 			lazy-init="true" init-method="bean1_init" destroy-method="bean1_destory"/>
 * 
 * 		<bean id='test7' class="kr.co.korea.beans.TestBean2"></bean>
 * 
 * - Bean 객체의 생명주기
 *  1)singleton인 경우에는 xml파일을 로딩할 때 객체가 생성됩니다.
 *  2)singleton이고, lazy-init = "true' 속성을 사용하면, getBean()을 사용할 때 객체가 생성됩니다.
 *  3)prototype인 경우에는 getBean()을 사용할 때 객체가 생성됩니다.
 *  4)객체의 소멸은 IoC컨테이너가 종료되면 소멸합니다.
 */

public class mainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean t1 = new TestBean();
		int result = t1.Adder(300, 200);
		System.out.println("덧셈의 합계1 : " + result);//500
		System.out.println(t1);
		
		TestBean t2 = context.getBean("tb1", TestBean.class);
		int result2 = t2.Adder(300, 200);
		System.out.println("덧셈의 합계2 : " + result2);//500
		System.out.println(t2);
		
		TestBean t3 = context.getBean("tb1", TestBean.class);
		int result3 = t3.Adder(300, 200);
		System.out.println("덧셈의 합계3 : " + result3);//500
		System.out.println(t3);
		
		TestBean t4 = context.getBean("tb2", TestBean.class);
		int result4 = t3.Adder(300, 200);
		System.out.println("덧셈의 합계4 : " + result4);//500
		System.out.println(t4);
		
		TestBean2 t5 = context.getBean("tb3", TestBean2.class);
		int result5 = t5.multi(300, 200);
		System.out.println("덧셈의 합계5 : " + result5);//60000
		System.out.println(t5);
		
		TestBean2 t6 = context.getBean("tb3", TestBean2.class);
		int result6 = t6.multi(300, 200);
		System.out.println("덧셈의 합계6 : " + result6);//60000
		System.out.println(t6);
		
		TestBean3 t7 = context.getBean("tb4", TestBean3.class);
		double result7 = t7.Adder(300, 200);
		System.out.println("덧셈의 합계7 : " + result7);//500.0
		System.out.println(t7);
		
		TestBean3 t8 = context.getBean("tb4", TestBean3.class);
		double result8 = t8.multi(300, 200);
		System.out.println("덧셈의 합계8 : " + result8);//60000.0
		System.out.println(t8);
		
		TestBean3 t9 = context.getBean("tb4", TestBean3.class);
		double result9 = t9.divi(300.0, 12.0);
		System.out.println("덧셈의 합계9 : " + result9);//25.0
		System.out.println(t9);
		
		context.close();
		
	}


}
