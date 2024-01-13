package com.ssafy.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// ProjectNameApplication.java
// application을 시작할 수 있는 main method가 존재하는 스프링 구성 메인 클래스

// start.spring.io
// Maven / Java / Jar / Java 8 
// Dependencies - Spring Boot DevTools, Spring Web, MyBatis Frameword, MySQL Driver

@SpringBootApplication
public class Spring12HelloBootBoardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Spring12HelloBootBoardApplication.class, args);
		for(String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
