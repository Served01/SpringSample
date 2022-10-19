package kr.co.ezen.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.DataBean2;
import kr.co.ezen.beans.DataBean3;
import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;

@Configuration
public class BeanConfigClass {

	@Bean
	public TestBean java1() { //java1의 이름이 객체명이 됩니다.
		return new TestBean(100, 123.456, "임성찬2", new DataBean());
	}
	
	@Bean
	public TestBean java2() {
		TestBean t1 = new TestBean();
		t1.setData1(500);
		t1.setData2(500.123);
		t1.setData3("임성찬4");
		t1.setData4(new DataBean());
		
		return t1;
	}
	
	@Bean
	public DataBean2 data1() {
		return new DataBean2();
	}
	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}
	
	//객체 주입(byName)
	@Bean(autowire = Autowire.BY_NAME)
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	@Bean
	public DataBean3 data100() {
		return new DataBean3();
	}
	
	//객체 주입 완료
	@Bean(autowire = Autowire.BY_TYPE)
	public TestBean3 java4() {
		return new TestBean3();
	}
	
	
}
