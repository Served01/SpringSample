package kr.co.ezen.main;


import java.util.Set;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.TestBean2;

public class mainClass4 {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans2.xml");
		
		TestBean2 t2 = context.getBean("tb2", TestBean2.class);
		
		Set<String> set1 = t2.getSet1();
		
		for(String string : set1) {
			System.out.println(string);
		}
		
		System.out.println("===================== String type =====================");
		
		Set<Integer> list2 = t2.getSet2();
		int sum = 0;
		
		for(Integer string2 : list2) {
			System.out.println(string2);
			sum = sum+string2;
			System.out.println("정수형 연산 결과: "+ sum);
		}
		
		System.out.println("===================== Integer type =====================");
		
		Set<Double> list3 = t2.getSet3();
		double sumDouble = 0;
		
		for(Double string3 : list3) {
			
			System.out.println(string3);
			sumDouble = sumDouble + string3;
			System.out.println("소수형 연산 결과: "+sumDouble);
		}
		
		System.out.println("===================== Double type =====================");
		
		context.close();
		
	}


}
