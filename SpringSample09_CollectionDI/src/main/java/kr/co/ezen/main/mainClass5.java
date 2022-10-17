package kr.co.ezen.main;


import java.util.Map;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.TestBean3;

public class mainClass5 {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans3.xml");
		
		TestBean3 t3 = context.getBean("tb3", TestBean3.class);
		
		Map<String, Object> map = t3.getMap1();
		
		String a1 = (String) map.get("a1");
		String a2 = (String) map.get("a2");
		Integer a3 = (Integer) map.get("a3");
		Integer a4 = (Integer) map.get("a4");
		Double a5 = (Double) map.get("a5");
		Double a6 = (Double) map.get("a6");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a3+a4);
		System.out.println(a5);
		System.out.println(a6);
		System.out.println(a5+a6);
		
		context.close();
		
	}


}
