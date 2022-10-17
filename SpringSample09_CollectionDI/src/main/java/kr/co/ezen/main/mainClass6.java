package kr.co.ezen.main;


import java.util.Properties;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.TestBean4;

public class mainClass6 {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans4.xml");
		
		TestBean4 t4 = context.getBean("tb4", TestBean4.class);
		
		Properties properties = t4.getProperties();
		
		String p1 = (String) properties.get("p1");
		String p2 = (String) properties.get("p2");
		String p3 = (String) properties.get("p3");
		String p4 = (String) properties.get("p4");
		String p5 = (String) properties.get("p5");
		String p6 = (String) properties.get("p6");
		
		System.out.println(p1);
		System.out.println(p2);
		Integer pp3 = Integer.parseInt(p3);
		Integer pp4 = Integer.parseInt(p4);
		System.out.println(pp3);
		System.out.println(pp4);
		System.out.println(pp3+pp4);
		double pp5 = Double.parseDouble(p5);
		double pp6 = Double.parseDouble(p6);
		System.out.println(pp5);
		System.out.println(pp6);
		System.out.println(pp5+pp6);
		
		context.close();
		
	}


}
