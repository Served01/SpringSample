package kr.co.ezen.main;


import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.beans.TestBean4;
import kr.co.ezen.processor.TestBeanPostProcessor;


/* BeanPostProcessor
 * --------------------------------------------------------------------------------------------------
 * - Bean 객체를 정의할 때 init-method 속성을 설정하면 객체가 생성될때 자동으로 호출될 메소드를 지정할 수 있습니다.
 * - 이때, BeanPostProcessor 인터페이스를 구현한 클래스를 정의하면 Bean 객체를 생성 할 때
 * 	 호출되는 init 메소드 호출을 가로채어 다른 메소드를 호출 할 수 있습니다.
 * - postProcessBeforeInitialization : init-method에 지정된 메소드가 호출되기 전에 호출합니다.
 * - postProcessAfterInitialization : init-method에 지정된 메소드가 호출된 다음에 호출합니다.
 * - init-method가 지정되어 있지 않더라도 자동으로 호출합니다.
 */

public class mainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		TestBean3 t3 = context.getBean("tb3", TestBean3.class);
		System.out.println("t3 : " + t3);
		
		TestBean4 t10 = context.getBean("tb4", TestBean4.class);
		System.out.println("t10 : " + t10);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("x의 값을 입력하세요.");
		int x = scanner.nextInt();
		System.out.println("y의 값을 입력하세요.");
		int y = scanner.nextInt();
		
		TestBeanPostProcessor.postProcessAfterInitialization(x,y);
		
		context.close();
	}


}