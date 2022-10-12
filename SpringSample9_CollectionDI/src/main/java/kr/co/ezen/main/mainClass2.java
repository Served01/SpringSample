package kr.co.ezen.main;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainClass2 {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동", 100);
		map.put("kim", 90);
		map.put("홍길순", 97);
		map.put("김수한무", 95);
		
		System.out.println(map);
		System.out.println(map.size());
		
		map.remove("홍길순");
		
		System.out.println(map);
		System.out.println(map.size());
		
		map.put("두루미", 100);
		
		System.out.println(map);
		System.out.println(map.size());
		
		//객체를 하나씩 찾아서 처리합니다.
		Set<String> keySet = map.keySet();
		Iterator<String> kIterator = keySet.iterator();
		
		while (kIterator.hasNext()) {
			String string = (String) kIterator.next();//key
			Integer valueInteger = map.get(string);
			
			System.out.println(valueInteger);
		}
		
		context.close();
		
	}


}
