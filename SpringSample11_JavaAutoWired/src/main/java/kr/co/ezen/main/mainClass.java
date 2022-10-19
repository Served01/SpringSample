package kr.co.ezen.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.config.BeanConfigClass;

/* 
 * 자바를 이용하여 자동 주입
----------------------------------------------------------
 - 기존에 생성자를 이용하여 직접 호출하거나, setter메소드를 이용하여 호출하고 값을 주입합니다.
 - 자동 주입
 
  1) xml
    <bean id='xml2' class='kr.co.korea.beans.TestBean2' lazy-init='true'
		autowire='byName'/>
	
    <bean class='kr.co.korea.beans.DataBean3'/>
    <bean id='xml3' class='kr.co.korea.beans.TestBean3' autowire='byType'/>


  2) Java Coding 방식
   @Bean(autowire= 주입방식) : 자동 주입 방식의 설정
     - @Bean(autowire = Autowire.BY_NAME)
	public TestBean2 java3() { : 이름을 이용하여 자동 주입
     - Autowire.BY_TYPE : 타입을 이용하여 자동 주입
     그런데, 스프링 5.1부터 Deprecated되었습니다. 
     5.1버전 부터는 Bean에 직접 설정하는 방식을 권고합니다.
    
	//자동 객체 주입 방식
		@Bean(autowire = Autowire.BY_NAME)
		public TestBean2 java3() {
			return new TestBean2();
		}
	
	//자동 객체 주입 방식
	@Bean(autowire = Autowire.BY_TYPE)
		public TestBean3 java4() {
			return new TestBean3();
		}


	 
 */

public class mainClass {

	public static void main(String[] args) {
		//XML 방식
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean t1 = context.getBean("xml1", TestBean.class);
		System.out.println(t1);// address value
		System.out.println(t1.getData1());// 100
		System.out.println(t1.getData2());// 임성찬
		System.out.println(t1.getData3());// 123.456
		System.out.println(t1.getData4());// address value
		System.out.println("----------xml1 area------------------");
		
		TestBean t2 = context.getBean("xml2", TestBean.class);
		System.out.println(t2);// address value
		System.out.println(t2.getData1());// 100
		System.out.println(t2.getData2());// 임성찬
		System.out.println(t2.getData3());// 123.456
		System.out.println(t2.getData4());// address value
		System.out.println("----------xml2 area------------------");
		
		TestBean2 t3 = context.getBean("xml3", TestBean2.class);
		System.out.println(t3);// address value
		System.out.println(t3.getData1());// address value
		System.out.println(t3.getData2());// address value
		System.out.println("----------xml3 area------------------");
		
		TestBean3 t4 = context.getBean("xml4", TestBean3.class);
		System.out.println(t4);// address value
		System.out.println(t4.getData1());// address value
		System.out.println(t4.getData2());// address value
		System.out.println("----------xml4 area------------------");
		
		
		context.close();
		
		//Java 방식
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean java1 = context2.getBean("java1", TestBean.class);
		System.out.println(java1);// address value
		System.out.println(java1.getData1());// 100
		System.out.println(java1.getData2());// 임성찬2
		System.out.println(java1.getData3());// 123.456
		System.out.println(java1.getData4());// address value
		System.out.println("---------java1 area--------------");
		
		TestBean java2 = context2.getBean("java2", TestBean.class);
		System.out.println(java2);// address value
		System.out.println(java2.getData1());// 500
		System.out.println(java2.getData2());// 임성찬4
		System.out.println(java2.getData3());// 500.123
		System.out.println(java2.getData4());// address value
		System.out.println("---------java2 area--------------");
		
		TestBean2 java3 = context2.getBean("java3", TestBean2.class);
		System.out.println(java3);// address value
		System.out.println(java3.getData1());// null => address value
		System.out.println(java3.getData2());// null => address value
		System.out.println("---------java3 area--------------");
		
		TestBean3 java4= context2.getBean("java4", TestBean3.class);
		System.out.println(java4);// address value
		System.out.println(java4.getData1());// null => address value
		System.out.println(java4.getData2());// null => address value
		System.out.println("---------java4 area--------------");
		
		
		
		context2.close();
	}	
}
