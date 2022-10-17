package kr.co.ezen.config;

import org.springframework.context.annotation.Bean;
import kr.co.ezen.beans.DataBean;
import kr.co.ezen.beans.TestBean;

public class BeanConfigClass {

	@Bean //method이름이 spring에서는 java에서 object이다.
	public TestBean java1() {
		return new TestBean(100, 123.456, "임성찬2", new DataBean());
	}
	
}
