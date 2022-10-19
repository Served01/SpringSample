package kr.co.ezen.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.config.BeanConfigClass;

/* 
 * Annotation Bean 설정
----------------------------------------
 - 기존에 xml이나 Annotation Bean 설정과 같은 방법을 이용하여 데이터를 처리해 왔습니다.
 - 그런데, 빈 설정 파일에 다음과 같은 코드를 설정하면 xml이 아닌 빈 클래스의 어노테이션을 검색하여 
   코드에 반영할 수 있습니다.

  <context:annotation-config/>

 - @Required : 반드시 주입해야 할 프로퍼티로 설정합니다.     
 - 5.1버전부터는 Deprecated되었고, 반드시 주입해야 할 프로퍼티는 생성자를 이용하여 주입하도록 변경되었습니다.

 	@Required : 3.x, 4.x 데이터 없으면 오류, 5.x에서는 데이터 없어도 실행
	public int getData1() {
		return data1;
	}
	
	@Required
	public void setData1(int data1) {
		this.data1 = data1;
	}

 - @Autowired : 객체 타입을 통하여 bean 객체를 자동으로 주입해 줍니다.
  
   @Autowired
     private DataBean1 data1;

   @Autowired
     public void setData2(DataBean1 data2){
	this.data2 = data2;
   }

  @Autowired
   public TestBean1(DataBean2 data3) {
    	this.data3 = data3;
   }

  @Qualifier : @Autowired로 주입할 경우에 타입의 Bean이 여러개인 경우에는 
  Qualifier에 설정 되어 있는 빈을  찾아서 주입을 합니다.
  * beans.xml의 id와 BeanConfigClass.java의 메소드명(오브젝트명)을 같게 해주면 됩니다.
	 
 */

public class mainClass {

	public static void main(String[] args) {
		//XML 방식
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean t1 = context.getBean("xml1", TestBean.class);
		System.out.println(t1);// address value
		System.out.println(t1.getData1());// 
		System.out.println(t1.getData2());// 
		System.out.println(t1.getData3());// 
		System.out.println(t1.getData4());// 
		System.out.println("----------xml1 area------------------");
		
		
		 TestBean2 t2 = context.getBean("xml2", TestBean2.class);
		 System.out.println(t2);// address value 
		 System.out.println(t2.getData1());// 0
		 System.out.println(t2.getData2());// address value
		 System.out.println("----------xml2 area------------------");
		 
		 /* 
		 * TestBean2 t3 = context.getBean("xml3", TestBean2.class);
		 * System.out.println(t3);// address value System.out.println(t3.getData1());//
		 * address value System.out.println(t3.getData2());// address value
		 * System.out.println("----------xml3 area------------------");
		 * 
		 * TestBean3 t4 = context.getBean("xml4", TestBean3.class);
		 * System.out.println(t4);// address value System.out.println(t4.getData1());//
		 * address value System.out.println(t4.getData2());// address value
		 * System.out.println("----------xml4 area------------------");
		 */
		
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
		
		
		 TestBean2 java2 = context2.getBean("java2", TestBean2.class);
		 System.out.println(java2);// address value
		 System.out.println(java2.getData1());// 0 
		 System.out.println(java2.getData2());// address value
		 System.out.println("---------java2 area--------------");
		  
		 TestBean3 java3 = context2.getBean("java3", TestBean3.class);
		 System.out.println(java3);// address value
		 System.out.println(java3.getData1());// 0  
		 System.out.println(java3.getData2());// null 
		 System.out.println(java3.getData3());// null 
		 System.out.println("---------java3 area--------------");
		  
			/*
			 * TestBean3 java4= context2.getBean("java4", TestBean3.class);
			 * System.out.println(java4);// address value
			 * System.out.println(java4.getData1());// null => address value
			 * System.out.println(java4.getData2());// null => address value
			 * System.out.println("---------java4 area--------------");
			 */
		 
		
		
		
		context2.close();
	}	
}
