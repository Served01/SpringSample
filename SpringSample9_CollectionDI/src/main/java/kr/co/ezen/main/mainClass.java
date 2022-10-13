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

/*
 * 
 *  - 빈을 정의할 때 주입해야 하는 멤버가 켈렉션인 경우에 컬렉션이 관리할 객체를 초기에 설정 할 수 있다.
 - List, Map(k, v), Set, Property를 사용합니다.
 - 자료구조: List, Set, Map(K, V), Properties
 - List : 순서가 있는 저장공간, 데이터의 중복을 허용합니다. stack, Array, Vector, ArrayList, LinkedList
 - Set : 순서가 없는 저장공간, 데이터의 중복을 허용X. HashSet, LinkedHashSet, TreeSet, SortedSet
 - Map(K, V): key는 중복 허용X, value는 중복 허용. HashTable, HashMap, TreeMap, LinkedHashMap, SortedMap 
 - Properties: Error Message 처리용 주로 사용


 - Collection(순서나 집합적인 저장공간)
   .List : 순서가 있는 저장공간, 데이터의 중복을 허용한다. 
      Stack : LIFO, FILO : 고정적인  메모리 크기
      Array의 단점 보완이 벡터입니다.
      Vector(10, 5) : 가변적인 메모리 구조 , 동기화 보장, 잘 쓰이지 않음.
      ArrayList : 아주 큰 데이터 저장공간, 동기화 보장 X, 속도가 아주 빠르고 크기를 마음대로 조절이 가능하다.
            단방향 구조이므로 순차적인 접근이 가능합니다.
      LinkedList : 양방향 구조, 삽입과 삭제가 아주 용이합니다.
	메모리의 특성 파악이 중요. => 운영체제 개발, C#, .NET
          => stack, queue, Dqueue을 만들기 위한 용도로 사용합니다.

   .Set : 순서 개념과는 상관없이 데이터의 중복을 허용하지 않는다. 
     HashSet : 대표 클래스, 가장 빠른 임의 접근 속도, 순서를 전혀 예측할 수 없음.
     LinkedHashSet : 추가된 순서, 또는 가장 최근에 접근한 순서대로 접근 가능.
     TreeSet : 정렬된 순서대로 보관하며 정렬 방법을 지정할 수 있다.
     SortedSet : 정렬

 - Map(키와 값으로 데이터 핸들링): key는 중복 허용 X, value는 중복 허용.
      Hashtable : 동기화 보장
           HashMap보다는 느리지만 동기화가 지원된다.
           키와 값으로 null이 허용 되지 않음.

      HashMap : 동기화 보장 X : TreeSet
          Map 인터페이스를 구현하기 위해서 해시테이블을 사용한 클래스
          중복 허용 하지 않고, 순서를 보장하지 않는다.
          키와 값으로 null이 허용.
         
      TreeMap :  이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장
         정렬된 순서로 키와 값을 저장하므로 빠른 검색이 가능
         그러나, 저장시에 오름차순을 하기 때문에 저장시간이 다소 오래 걸림.

      LinkedHashMap :  HashMapd을 상속 받는다.
          Map에 있는 엔트리들의 연결 리스트를 유지하므로 입력한 순서대로 반복이 가능

      SortedMap : 정렬    : TreeMap

 .Properties : Spring 3.X 사용 : Error message 처리 주로 사용.
 -  Hashtable의 상속을 받아 구현, Hashtable은 키와 값을 저장(Object, Object)하는데 비해서
    Properties는 (String, String)의 형태로 저장합니다.
    주로 애플리케이션의 환경설정과 관련한 속성을 저장하는 데 사용.
    데이터를 파일로부터 읽고 쓰는데 편리한 기능을 제공합니다.
 * 
 * 
 */
