package com.ssafy.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Desktop d1 = context.getBean("desktop", Desktop.class);
		Desktop d2 = context.getBean("desktop", Desktop.class);
		
		// 스프링은 기본적으로 싱글턴이라는 컨셉을 가지고 있다.
		System.out.println(d1 == d2);
		
		// 테스트
		Programmer p = (Programmer) context.getBean("programmer");
		p.coding();
	}

}
