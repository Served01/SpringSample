package kr.co.ezen.main;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean;





public class mainClass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean t1 = context.getBean("tb1",TestBean.class);
		System.out.println(t1); //address value = pointer
		System.out.println(t1.getData1()); //null => @368247b9
		System.out.println(t1.getData2()); //null => @1a6d8329
		
		context.close();
		
	}


}

/*
 * 
 자동 주입(AutoWire)
--------------------------------
 - 기존에 생성자 주입, setter 주입 등을 이용하였는데, 좀 더 편리한 방법인 자동 주입에 대하여 알아봅니다. 
	자동 주입은 이름, 타입, 생성자를 통하여 할 수 있는데, autowire라고 부릅니다.

 - 자동 주입은 객체 주소 값만 가능하므로 참조 변수를 제외한 나머지들은 직접 명시를 해 주어야 합니다.
   즉, 문자열, 정수형, 실수형 등

  1) 이름을 이용하여 주입
     - byName : 빈 객체의 프로퍼티 이름과 정의 된 빈의 이름이 같는 것을 찾아서 자동으로 주입을 합니다.

    <bean id="data1" class="kr.co.korea.beans.DataBean1"/>
     
    TestBean1
        private DataBean1 data1;
        private DataBean1 data2;
 
   <!-- 이름에 의한 자동 주입 방식 옵션 -->
	<bean id='obj2' class='kr.co.korea.beans.TestBean' autowire="byName"/>  
	
	<bean class='kr.co.korea.beans.TestBean'></bean>
	
	<!-- 자동 주입 빈  정의 -->
	<bean id='data1' class='kr.co.korea.beans.DataBean'/>
	<bean id='data2' class='kr.co.korea.beans.DataBean'/>
	

  2) 타입을 이용하여 주입
     - byType : 빈 객체의 프로퍼티 타입과 정의 된 빈의 타입이 일치할 경우에 주입됩니다.

    <bean id="data2" class="kr.co.korea.beans.DataBean2"/>
     
    TestBean2
        private DataBean2 data1;
        private DataBean2 data2;

<!-- 이름에 의한 자동 주입 방식 옵션 -->
	<bean id='obj3' class='kr.co.korea.beans.TestBean2' autowire="byType"/>
	
	<bean class='kr.co.korea.beans.TestBean2'></bean>
	
	<!-- 자동 주입 빈  정의 -->
	<bean  class='kr.co.korea.beans.DataBean2'/>
	
	<!-- 동일 타입인 경우에는 여러개가 존재하면 오류 발생 그러므로 하나만 정의하여 사용하라. -->
	<!-- <bean  class='kr.co.korea.beans.DataBean2'/> -->
	<!-- <bean  class='kr.co.korea.beans.DataBean2'/> -->
 */
