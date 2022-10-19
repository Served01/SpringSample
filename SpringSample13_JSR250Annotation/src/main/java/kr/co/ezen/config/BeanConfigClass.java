package kr.co.ezen.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.DataBean2;
import kr.co.ezen.beans.DataBean3;
import kr.co.ezen.beans.TestBean;
import kr.co.ezen.beans.TestBean2;
import kr.co.ezen.beans.TestBean3;
import kr.co.ezen.beans.TestBean4;
import kr.co.ezen.beans.TestBean5;

@Configuration
public class BeanConfigClass {
	
	@Bean(initMethod = "init1", destroyMethod = "destroy1")
	@Lazy
	public TestBean obj1() {
		
		return new TestBean();
	}
	
	@Bean
	@Lazy
	public TestBean2 obj2() {
		
		return new TestBean2();
	}
	
	@Bean
	public DataBean data1() {
		return new DataBean();
	}
	
	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}
	
	@Bean
	public DataBean3 data3() {
		return new DataBean3();
	}
	
	//객체 주입
	@Bean(autowire = Autowire.BY_NAME)
	@Lazy
	public TestBean3 obj3() {
		
		return new TestBean3();
	}
	
	@Bean
	public TestBean4 obj4() {
		TestBean4 t4 = new TestBean4();
		t4.setData4(2000);
		
		return t4;
	}
	
	@Bean
	public TestBean5 obj5() {
		TestBean5 t5 = new TestBean5();
		t5.setData4(12000);
		
		return t5;
	}
	
	
}
