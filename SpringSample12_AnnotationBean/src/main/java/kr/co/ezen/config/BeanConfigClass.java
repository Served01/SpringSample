package kr.co.ezen.config;

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
	public TestBean java1() {
		TestBean t1 = new TestBean();
		t1.setData1(500);
		t1.setData2(500.123);
		t1.setData3("임성찬4");
		t1.setData4(new DataBean());
		
		return t1;
	}
	
	@Bean
	public TestBean2 java2() {
		TestBean2 t2 = new TestBean2();		
		t2.setData1(1500);
		t2.setData2(new DataBean2()); 
		return t2;
	}
	
	@Bean
	public DataBean2 data_bean2() {
				
		return new DataBean2();
	}
	
	@Bean
	public TestBean3 java3() {
		TestBean3 t3 = new TestBean3();		
		t3.setData1(1500);
		//t3.setData3(new DataBean3()); 
		return t3;
	}
	
	@Bean
	public DataBean3 data_bean3() {
				
		return new DataBean3();
	}
	
	
}
