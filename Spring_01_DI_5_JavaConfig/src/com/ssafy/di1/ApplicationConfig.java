package com.ssafy.di1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// 빈 등록 방법 (1) 
// @Configuration & @Bean

@Configuration // 스프링 설정파일임을 지정하는 어노테이션
public class ApplicationConfig {
	
	@Bean // 빈 등록
//	@Scope("prototype") // 스코프의 기본값은 싱글턴인데, 이를 프로토타입으로 바꾸면 객체를 매번 생성해준다.
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean // 빈 등록
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean // 빈 등록
	public Programmer programmer() {
		
		// 설정자 주입
//		Programmer pr = new Programmer();
//		pr.setComputer(desktop()); 
		
		// 생성자 주입
		Programmer pr = new Programmer(desktop()); 
		return pr;
	}
	
}
