
public class Adder {

	public static void main(String[] args) {
		int sum = 100 + 500;
		System.out.println("Adder: " + sum);


	}

}
/*
Spring (2003년 2월 Expert one-on-one J2EE Design and Development 라는 책을 통하여 오픈소스 형태로 시작, 2008년경 탄생 = 로드존슨, 2013년 11월 중순경 채택 => 전자정부 프레임워크로 사용하기 시작)
-핵심 계층
 1)프레젠 테이션 계층 : SpringFramework
  - 사용자 인터페이스 역할
  - 브라우저상에서 클라이언트의 요청 및 응답을 처리
  - 서비스 계층, 데이터 엑세스 계층에서 발생하는 예외상황을 처리
  - @Controller 사용하여 처리힙니다.
  
 2)제어 계층 : 프리젠테이션 계층과 비지니스 로직 계층을 분리하기 위하여 컨트롤러를 제공한다.
 3)비지니스 로직(Service) 계층 : 핵심 업무를 어떻게 처리하는가를 보여주는 방법이 기술된 계층
  - 애플리케이션의 비지니스 로직 처리와 관련된 도메인 모델의 적합성(Validation) 검증
  - Transaction 관리
  - Service 인터페이스와 @Service 사용하여 Service class를 구현
  - 프리젠테이션 계층과 Persistence (DAO) 계층을 연결하는 역할을 하는데,
  	이는 두 계층이 직접적으로 통신하지 않도록 하는 것이 이유입니다.
  	why) 1. 코드의 재사용성
  		 2. 유지보수의 편리성
  		 3. 확장성
 
 4)Persistence (DAO) 계층 : 데이터 처리를 담당(DB CRUD), DTO = VO
  - ORM(MyBatis, Hibernate 등)을 주로 사용하는 계층
  - DAO 인터페이스와 @Repository를 사용하여 DAO class를 구현
  - DataBase에 CRUD하는 계층
  
 5)도메인 모델 계층 : 각 계층 사이에 전달되는 파라메터(객체)
  - DB의 테이블과 같다.
  - 테이블과 매칭되는 클래스가 존재
  - Entity class
  
  .MVC Pattern
  MVC(M: Model, V: View, C: Controller)
   : 사용자 인터페이스와 애플리케이션 로직을 분리하기 위하여
   1)Model : 모델 컴포넌트
    시스템의 비지니스 로직을 포함하고, 애플리케이션의 상태를 나타내는 데이터 계층
    프리젠테이션 레이어와 무관하며, 컨트롤러는 모델 레이어에서 데이터를 가져다가 뷰 레이어로 전달합니다.
    => studentDTO = studentVO = student DAO, studentDAO class, Service Class에 해당
    
   2)View : 뷰 컴포넌트
   	UI형식의 응용 프로그램 출력을 표시합니다.
   	모델이 처리한 데이터나 그 작업 결과를 가지고 사용자에게 출력할 화면을 만드는 일을 합니다.
   	
   3)Controller 컴포넌트
    View와 Model간의 인터페이스 역할

  .Spring MVC 주요 구성 요소
  1)브라우저 요청
  2)서블릿이 핸들러 매핑에게 전달
  3)핸들러 매핑이 어떤 컨트롤러가 처리할지를 결정해서 서블릿에게 전달
  4)서블릿은 전달받아서 해당 컨트롤러에게 전달
  5)컨트롤러는 이를 처리
  6)결과를 모델앤뷰에게 전달
  7)모델앤뷰는 다시 서블릿에게
  8)서블릿을 다시 뷰리졸버에게 전달
  9)뷰리졸버는 다시 서블릿에게
  10)서블릿은 뷰에게
  11)뷰는 브라우저에게 결과를 전달
  
  .Maven : 스프링 프레임워크 라이브러리 관리하기 위하여 사용
   - 라이브러리 의존성
   - 자동화 시키기에 편리함
  
*/