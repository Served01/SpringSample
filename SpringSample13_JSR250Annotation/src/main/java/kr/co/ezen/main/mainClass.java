package kr.co.ezen.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.beans.TestBean4;
import kr.co.ezen.beans.TestBean5;
import kr.co.ezen.config.BeanConfigClass;

/* 
 *JSR-250 Annotation
------------------------------
 - 스프링에서 기본적으로 제공하지는 않지만, 자바 플랫폼의 공통 어노테이션이다.
 - 적용하려면 반드시 라이브러리를 추가해야 합니다.

   @PostConstruct     //생성자 호출 이후에 자동으로 호출
	public void init2() {
		System.out.println("TestBean2의 init()");
	}

   @PreDestroy //객체가 소멸되기 전에 자동으로 호출
	public void destroy2() {
		System.out.println("TestBean2의 destroy()");
	}
  
 *하나의 클래스에 메소드나 생성자가 존재하면 어노테이션이 적용되지만, 
  각각의 클래스에서 분할 실행하면 적용이 안됩니다.

 -@Resource : Bean의 이름을 통하여 주입합니다.

    @Resource	 //setter의 역할
	private DataBean data1;
	
	@Resource
	private DataBean2 data2;
	
	@Resource
	private DataBean3 data3;
	

	public DataBean getData1() {
		return data1;
	}

	public DataBean2 getData2() {
		return data2;
	}

	public DataBean3 getData3() {
		return data3;
	}
	
	 
 */

public class mainClass {

	public static void main(String[] args) {
		//XML 방식
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		//context.close();
		
		//Java 방식
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean obj1 = context.getBean("obj1", TestBean.class);
		System.out.println(obj1); // address value
		
		TestBean2 obj2 = context.getBean("obj2", TestBean2.class);
		System.out.println(obj2); // address value
		obj2.message();  		
		
		TestBean3 obj3 = context.getBean("obj3", TestBean3.class);
		System.out.println(obj3); // null => address value
		System.out.println(obj3.getData1());// null => address value
		System.out.println(obj3.getData2());// null => address value
		System.out.println(obj3.getData3());// null => address value
		 		
	/* 문제> TestBean4 클래스가 존재 합니다.
	 *  1. DataBean data1;
	 *  2. DataBean2 data2;
	 *  3. DataBean3 data3;
	 *  
	 *  @Autowire를 이용하여 객체를 주입하세요.
	 *  
	 * 문제2> TestBean5 클래스를 사용하여 @Resource를 이용한 객체를 주입하세요.
	 *   
	 */
	System.out.println("----------obj4 area------------------");
		TestBean4 obj4 = context.getBean("obj4", TestBean4.class);
		System.out.println(obj4); // null => address value
		System.out.println(obj4.getData1());// null => address value
		System.out.println(obj4.getData2());// null => address value
		System.out.println(obj4.getData3());// null => address value
		System.out.println(obj4.getData4());// 2000
	
		System.out.println("----------obj5 area------------------");
		TestBean5 obj5 = context.getBean("obj5", TestBean5.class);
		System.out.println(obj5); // null => address value
		System.out.println(obj5.getData1());// null => address value
		System.out.println(obj5.getData2());// null => address value
		System.out.println(obj5.getData3());// null => address value
		System.out.println(obj5.getData4());// 12000
		
		context.close();
	}	
}
