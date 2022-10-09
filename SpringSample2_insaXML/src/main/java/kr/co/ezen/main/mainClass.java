package kr.co.ezen.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.HelloKor;
import kr.co.ezen.beans.HelloEng;



/* 문제> 안녕하세요라는 메세지를 영문버전과 한글버전으로 출력하세요.
 * 영문> Hi~
 * 한글> 방가방가~
 */

public class mainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		HelloEng heEng = (HelloEng) context.getBean("helloEng");
		callHelloEng(heEng);
			
		HelloKor heKor = (HelloKor) context.getBean("helloKor");
		callHelloKor(heKor);
	
		context.close();

	}

	private static void callHelloKor(HelloKor heKor) {
		heKor.sayHalo();
		
	}

	private static void callHelloEng(HelloEng heEng) {
		heEng.sayHalo();
		
	}


}
