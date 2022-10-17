package kr.co.ezen.main;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.beans.TestBean4;





public class mainClass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean t1 = context.getBean("tb1", TestBean.class);
		System.out.println(t1);// address value = pointer 		
		System.out.println(t1.getData1());// null => @5677323c		
		System.out.println(t1.getData2());// null => @18df8434
		System.out.println("----------tb1 area-----------------");
		
		
		TestBean t2 = context.getBean("tb2", TestBean.class);
		System.out.println(t2);// address value = pointer 
		//t2.setData1("ㅇㅇㅇㅇㅇㅇ"); 기본 자료형은 사용불가, reference 타입은 가능(객체)
		System.out.println(t2.getData1());// null => @1e6a3214
		
		System.out.println(t2.getData2());// null => @368247b9
		t2.setData3(1000);
		System.out.println(t2.getData3());// null => 0
		t2.setData4(100.00);
		System.out.println(t2.getData4());// null => 0.0
		t2.setData5("반가워요~~~.");
		System.out.println(t2.getData5());// null => null
		System.out.println("----------tb2 area-----------------");
		
		TestBean2 t3 = context.getBean("tb3",TestBean2.class);
		System.out.println(t3); //address value = pointer
		System.out.println(t3.getData1()); //null => 
		System.out.println(t3.getData2()); //null => 
		System.out.println("-------------------tb3 area------------------------");
		
		TestBean2 t4 = context.getBean("obj",TestBean2.class);
		System.out.println(t4); //address value = pointer
		System.out.println(t4.getData1()); //null => @76a4ebf2
		System.out.println(t4.getData2()); //null => @2e8c1c9b
		System.out.println("-------------------obj area------------------------");
		
		TestBean3 t5 = context.getBean("obj2",TestBean3.class);
		System.out.println(t5); //address value = pointer
		System.out.println(t5.getData1()); //0 => 
		System.out.println(t5.getData2()); //null => 
		System.out.println(t5.getData3()); //0.0 => 
		System.out.println(t5.getData4()); //null => 
		System.out.println(t5.getData5()); //null => 
		System.out.println("-------------------obj2 area------------------------");
		
		TestBean4 t6 = context.getBean("obj3",TestBean4.class);
		System.out.println(t6); //address value = pointer
		System.out.println(t6.getData1()); //0 => 
		System.out.println(t6.getData2()); //null => 
		System.out.println(t6.getData3()); //0.0 => 
		System.out.println(t6.getData4()); //null => 
		System.out.println(t6.getData5()); //null => 
		System.out.println("-------------------obj3 area------------------------");
		
		TestBean4 t7 = context.getBean("obj5",TestBean4.class);
		System.out.println(t7); //address value = pointer
		System.out.println(t7.getData1()); //0 => 
		System.out.println(t7.getData2()); //null => 
		System.out.println(t7.getData3()); //0.0 => 
		System.out.println(t7.getData4()); //null => 
		System.out.println(t7.getData5()); //null => 
		System.out.println("-------------------obj5 area------------------------");
		
		TestBean4 t8 = context.getBean("obj6",TestBean4.class);
		System.out.println(t8); //address value = pointer
		System.out.println(t8.getData1()); //0 => 
		System.out.println(t8.getData2()); //null => 
		System.out.println(t8.getData3()); //0.0 => 
		System.out.println(t8.getData4()); //null => 
		System.out.println(t8.getData5()); //null => 
		System.out.println("-------------------obj6 area------------------------");
		
		TestBean4 t9 = context.getBean("obj7",TestBean4.class);
		System.out.println(t9); //address value = pointer
		System.out.println(t9.getData1()); //0 => 
		System.out.println(t9.getData2()); //null => 
		System.out.println(t9.getData3()); //0.0 => 
		System.out.println(t9.getData4()); //null => 
		System.out.println(t9.getData5()); //null => 
		System.out.println("-------------------obj7 area------------------------");
		
		
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

  3) 생성자를 이용하여 주입
   - Constructor : 생성자의 매개변수 타입과 정의 빈의 타입이 같은 경우  주입이 된다.
      동일한 타입의 빈이 두개 이상 정의되어 있으면 오류가 발생합니다.

  <bean id="data20" class="kr.co.korea.beans.DataBean3"/>
  
   public TestBean3(DataBean3 data20, DataBean3 data30) {
	this.data20 = data20;
	this.data30 = data30;
   }


<bean id='obj4' class='kr.co.korea.beans.TestBean3'>
		<constructor-arg ref='data_bean2' index="0"/>
		<constructor-arg ref='data_bean2' index="1"/>
	</bean>
	
	<!-- 매개변수가 없이 생성자를 주입하여 객체를 생성하는 경우 -->
	<bean id='obj5' class='kr.co.korea.beans.TestBean3' autowire='constructor'/>
	
	<bean id='obj6' class='kr.co.korea.beans.TestBean3'>
		<constructor-arg value='12345' index='0' type='int'/>
		<constructor-arg value='홍길동'  index='1'/>
		<constructor-arg ref='data_bean2' index='2'/>
		<constructor-arg ref='data_bean2' index='3'/>	
	</bean>


	- default-autowire="byName"
	
 */
