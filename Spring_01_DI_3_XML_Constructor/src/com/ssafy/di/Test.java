package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Spring을 통한 개발
		// applicationContext.xml에 저장한 스프링의 빈(자바의 클래스)을 활용!
		ApplicationContext context = new  GenericXmlApplicationContext("applicationContext.xml");
		
		// test
		Programmer p = context.getBean("programmer", Programmer.class);
		p.coding();
	}

}
