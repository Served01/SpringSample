package kr.co.ezen.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import kr.co.ezen.beans.HelloEng;
import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;

/* IoC
 * - Inversion of Control : 개발자가 코드 등의 흐름이나 객체 생성에 관련된 코드를 프로그래밍에 직접
작성하는 것이 아니라, 프레임워크가 사용하는 파일에 작성하여 이를 토대로 프레임워크가 객체를 생성하고, 
반환하고, 코드가 동작하는 순서를 결정하는 것을 의미합니다.

-객체의 생성, 생명주기의 관리까지 모든 객체에 대한 제어권을 가진다.
-IoC 컨테이너는 객체의 생성을 책임지고, 의존성을 관리합니다.
-POJO의 생성, 초기화, 서비스, 소멸에 대한 권한을 가지게됩니다.
-개발자들이 직접 POJO를 생성 할 수 있지만, 컨테이너에게 맡깁니다. (Bean등록=> xml파일)

-2가지 표현
1.의존성 검색 : DL(DataBase연결), Connection Pool(Server.xml), Driver
  - DL(DB연결)
      Class.forName("oracle.jdbc.OracleDriver");
      String url="jdbc:oracle:thin:@localhost:1521:xe";
      String id="hyun";
      String pw="oraclejava";
      conn = DriverManager.getConnection(url, id, pw); 
  
  - Connection Pool(server.xml, context.xml)

 Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();

  <Context> 
  <Resource name="jdbc/OracleDB" 
   auth="Container"
   type="javax.sql.DataSource" 
   username="oraclejava" 
   password="oraclejava"
   driverClassName="oracle.jdbc.driver.OracleDriver"
   factory="org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory"
   url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
   maxActive="500" 
   maxIdle="100"/>  
</Context>


2.의존성 주입 : DI => Setter Injection, Constructor Injection, Method Injection
  각 클래스간에 의존관계를  빈 설정 정보를 바탕으로 컨테이너가 자동으로 연결해 줍니다.
 
 - 객체의 생성은 빈 등록이 아니라, getBean()를 호출함으로써 객체가 생성됩니다. 

-종류
1)BeanFactory : 3.X주로 사용
 -클래스를 통하여 객체를 생성하고, 이를 전달합니다.
 -상속 등 객체간의 관계를 형성하고 관리합니다.
    <종류>
	ApplicationEventPublisher, ListableBeanFactory, MessageSource, 
	ResourceLoader  ... 
 -XmlBeanFactory 

2)ApplicationContext
 - BeanFactory 상속받아 기본적인 컨테이너 기능 + 확장 기능 제공
 - 확장한 기능 : 메시지 소스 처리 기능, 이벤트 발행기능, 리소스 로딩 기능, 트랜잭션 관리 등등..
   컨테이너의 구동되는 시점에 bean에 등록되어 있는 클래스를 객체화하는 즉시 로딩 방식.
 -클래스를 통하여 객체를 생성하고, 이를 전달합니다.
 -상속 등 객체간의 관계를 형성하고 관리합니다.
 -국제화 지원 등 문자열에 대한 다양한 기능을 제공합니다.
 -리스너로 등록되어 있는 Bean에 이벤트를 발생할 수 있다.
 -Bean에 관련한 설정을 위한 xml 파일은 즉시 로딩되어서 객체를 미리 생성하여 가지게 됩니다.
     <종류>
	StaticApplicationContext, genericXmlApplicationContext, WebApplicationContext,
	XmlWebApplicationContext ...
 -ClassPathXmlApplicationContext
 -FileSystemXmlApplicationContext
 -XmlWebApplicationContext
 * 
 */

@SuppressWarnings("deprecation")
public class mainClass {

	public static void main(String[] args) {
		ClassPathResource context = new ClassPathResource("kr/co/ezen/config/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(context);

		TestBean t1 = factory.getBean("testBean", TestBean.class);
		System.out.println(t1);//address value = pointer value
		t1.Adder();
		
		TestBean t2 = factory.getBean("testBean", TestBean.class);
		System.out.println(t2);//address value = pointer value => single type
		
		TestBean t3 = factory.getBean("testBean2", TestBean.class);
		System.out.println(t3);//
		t3.Adder();
		
		HelloEng t4 = factory.getBean("testBean3", HelloEng.class);
		System.out.println(t4);//
		t4.sayHalo();
		
		TestBean2 tb2 = new TestBean2();
		int result = tb2.Adder(300, 200);
		System.out.println("덧셈의 합계 : " + result);//500
		
		//DI 주입
		TestBean2 tb3 = factory.getBean("tb2", TestBean2.class);
		int result2 = tb3.Adder(300, 300);
		System.out.println("덧셈의 합계2 : " + result2);//600
		
		TestBean3 tb4 = factory.getBean("tb3", TestBean3.class);
		int result3 = tb4.Subtract(1300, 300);
		System.out.println("뺄셈의 합계3 : " + result3);//1000
		
	}


}
