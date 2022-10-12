package kr.co.ezen.main;


import java.awt.geom.Point2D;
import java.util.Scanner;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezen.beans.TestBean;
/*
Constructor Injection
--------------------------------
- Constructor Injection : 필요한 의존성을 포함한 클래스의 생성자를 만들고 이를 통하여 의존성을 주입합니다. 
   빈(Constructor Injection)을 정의할 때, constructor-arg태그를 이용하여 주입하게되면 생성자를
   통하여 주입할 수가 있습니다. 불변이고 고정적인 값을 주로 주입합니다.
   
   - value: 기본 자료형이나 문자열 값을 설정
   - ref: 객체를 설정
   - type: 저장할 값의 타입을 설정
   - index: 지정된 값을 주입할 생성자의 매개변수 인덱스 번호 설정
   - 데이터 처리 기준: 문자열 1위, 실수형2위, 정수형3위

	<bean id='t7' class='kr.co.oracle.beans.TestBean'>
		<constructor-arg value='100' type='int' index='0'/>
		<constructor-arg value='100.123456' type='double' index='1'/>
		<constructor-arg value='안녕하세요?' index='2'/>
	</bean>

	//정수형, 실수형, 문자열형
	<bean id='test1' class="kr.co.oracle.beans.TestBean" lazy-init='true'>
		<constructor-arg value='홍길동' type='String' index='2'/>
		<constructor-arg value='500.123' type='double' index='1'/>
		<constructor-arg value='123456' type='int' index = '0'/>		
	</bean>

	<bean id='t8' class='kr.co.oracle.beans.TestBean2'>
		<constructor-arg ref='data_bean2'/>
		<constructor-arg ref='data_bean2'/>
	</bean>


*/





public class mainClass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/co/ezen/config/beans.xml");
		
		/*Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		double y = scanner.nextDouble();
		boolean b = scanner.nextBoolean();
		String z = scanner.next();
		
		TestBean t1 = new TestBean();
		*/
		TestBean t1 = context.getBean("tb1", TestBean.class);
		/*System.out.println(t1);// address value = pointer value
		t1.setData1(x);
		t1.setData2(y);
		t1.setData3(b);
		t1.setData4(z);
		*/
		System.out.println(t1.getData1());//1500
		System.out.println(t1.getData2());
		
		System.out.println(t1.getData4());
		
		
		context.close();
		
	}


}
