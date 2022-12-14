package kr.co.ezen.main;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.beans.TestBean4;


/* 스프링 빈 : 스프링 IoC 컨테이너가 관리하는 객체
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
		
		TestBean3 t3 = context.getBean("tb3", TestBean3.class);
		System.out.println("t3 : " + t3);
		
		TestBean3 t7 = context.getBean("tb3", TestBean3.class);
		double result7 = t7.Adder(300, 200);
		System.out.println("덧셈의 합계7 : " + result7);//500.0
		System.out.println(t7);
		
		TestBean3 t8 = context.getBean("tb3", TestBean3.class);
		double result8 = t8.multi(300, 200);
		System.out.println("덧셈의 합계8 : " + result8);//60000.0
		System.out.println(t8);
		
		TestBean3 t9 = context.getBean("tb3", TestBean3.class);
		double result9 = t9.divi(300.0, 12.0);
		System.out.println("덧셈의 합계9 : " + result9);//25.0
		System.out.println(t9);
		System.out.println("======================================================================================");
		
		TestBean4 t10 = context.getBean("tb4", TestBean4.class);
		System.out.println("t10 : " + t10);
		
		context.close();
	}


}
