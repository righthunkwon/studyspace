package com.ssafy.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// start.spring.io
// Maven / Java / Jar / Java 8 / Dependencies - Spring Boot DevTools, Spring Web

// 참고) Lombok
// Lombok을 설치하고 @Data 어노테이션을 붙여주면 DTO에서 필드만 정의하더라도 
// Getter & Setter, 생성자, toString을 자동으로 사용할 수 있어서 코드 길이를 줄여준다.

@SpringBootApplication
public class Spring12HelloBootApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Spring12HelloBootApplication.class, args);
		
		// 등록된 모든 bean들의 이름을 출력
		for(String name: context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
