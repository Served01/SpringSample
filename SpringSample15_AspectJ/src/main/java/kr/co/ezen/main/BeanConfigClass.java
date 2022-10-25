package kr.co.ezen.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//XML 설정과 같은 동작하는 클래스
@Configuration
@ComponentScan(basePackages = {"kr.co.ezen.beans", "kr.co.ezen.advisor"})
@EnableAspectJAutoProxy
public class BeanConfigClass { 

}
