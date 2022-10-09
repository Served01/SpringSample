package kr.co.ezen.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.HelloEng;
import kr.co.ezen.beans.HelloKor;
import kr.co.ezen.beans2.HelloEng2;
import kr.co.ezen.beans2.HelloKor2;
import kr.co.ezen.beans3.HelloEng3;
import kr.co.ezen.beans3.HelloKor3;


/* 문제> 안녕하세요라는 메세지를 영문버전과 한글버전으로 출력하세요.
 * 영문> Hello~
 * 한글> 안녕하세요~
 * 
 * 문제2> interface를 적용하여 출력하세요.
 * 
 * 문제3> abstract class를 적용하여 출력하세요
 */

public class mainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		HelloEng hEng = new HelloEng();
		hEng.Hello();
		
		HelloKor hKor = new HelloKor();
		hKor.Hello();
		
		HelloEng.Hello();
		HelloKor.Hello();
		System.out.println("==============================");
		
		//interface 적용로직
			
		HelloEng2 hEng2 = new HelloEng2();
		callHelloEng(hEng2);
			
		HelloKor2 hKor2 = new HelloKor2();
		callHelloKor(hKor2);
		System.out.println("==============================");
		
		//abstract class 적용
		
		HelloEng3 hEng3 = new HelloEng3();
		callHelloEng3(hEng3);
			
		HelloKor3 hKor3 = new HelloKor3();
		callHelloKor3(hKor3);
	
		context.close();

	}

	private static void callHelloKor3(HelloKor3 hKor3) {
		hKor3.sayHalo();
		
	}

	private static void callHelloEng3(HelloEng3 hEng3) {
		hEng3.sayHalo();
		
	}

	private static void callHelloEng(HelloEng2 hEng2) {
		hEng2.sayHello();
		
	}
	
	private static void callHelloKor(HelloKor2 hKor2) {
		hKor2.sayHello();
		
	}

}
