package kr.co.ezen.main;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;





public class mainClass {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		@SuppressWarnings({ "rawtypes" })
		List list1 = new ArrayList();
		
		list1.add("홍길동");
		list1.add("kim gil dong");
		list1.add(new String("홍길순"));
		list1.add("12345");
		
		System.out.println(list1);
		
		list1.add(1,"1000");
		
		System.out.println(list1);
		
		boolean boo = list1.contains("홍길순");
		
		System.out.println(boo);
		
		int idx = list1.indexOf("홍길순");
		list1.add(idx,"김수한무거북이와두루미");
		
		System.out.println(list1);
		
		list1.remove(4);
		System.out.println(list1);
		
		//가변 반복문 이용 조회
		for(Object str : list1) {
			System.out.println(str);
		}
		
		//index를 이용한 데이터 조회
		for(int i=0; i<list1.size(); i++) {
			String str = (String) list1.get(i);
			System.out.println(str);	
		}
		
		//Iterator 조회
		@SuppressWarnings("rawtypes")
		Iterator iterator = list1.iterator();
		
		while(iterator.hasNext()) {
			
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
		
		
		context.close();
		
	}


}
