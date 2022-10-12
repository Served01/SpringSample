package kr.co.ezen.main;


import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.TestBean;

public class mainClass3 {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean t1 = context.getBean("tb1", TestBean.class);
		
		List<String> list1 = t1.getList1();
		
		for(String string : list1) {
			System.out.println(string);
		}
		
		System.out.println("===================== String type =====================");
		
		List<Integer> list2 = t1.getList2();
		int sum = 0;
		
		for(Integer string2 : list2) {
			System.out.println(string2);
			sum = sum+string2;
			System.out.println("정수형 연산 결과: "+ sum);
		}
		
		System.out.println("===================== Integer type =====================");
		
		List<Double> list3 = t1.getList3();
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
