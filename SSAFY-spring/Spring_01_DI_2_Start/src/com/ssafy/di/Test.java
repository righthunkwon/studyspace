package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 자바의 클래스 = 스프링의 빈
public class Test {
	public static void main(String[] args) {
		// Spring을 통한 개발
		// applicationContext.xml에 저장한 스프링의 빈(자바의 클래스)을 활용!
		ApplicationContext context = new  GenericXmlApplicationContext("applicationContext.xml");
		
		// context가 가지고 있는 bean을 가져와서 인스턴스를 생성(클래스임을 명시)
		Programmer p1 = context.getBean("programmer", Programmer.class);
		Desktop d1 = context.getBean("desktop", Desktop.class);
		Laptop l1 = context.getBean("laptop", Laptop.class);
		
		// context가 가지고 있는 bean을 가져와서 인스턴스를 생성(강제 형변환 활용)
		Programmer p2 = (Programmer) context.getBean("programmer");
		Desktop d2 = (Desktop) context.getBean("desktop");
		Laptop l2 = (Laptop) context.getBean("laptop");
		
		// 싱글톤 패턴으로 가져오는 것임을 확인
		System.out.println(p1 == p2); // true
		System.out.println(d1 == d2); // true
		System.out.println(l1 == l2); // true
		
		// test
		p1.coding(d1);
		p1.coding(l1);
	}

}
