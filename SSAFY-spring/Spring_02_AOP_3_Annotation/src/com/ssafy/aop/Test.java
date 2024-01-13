package com.ssafy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Spring AOP
// Aspect는 공통 관심사항

// (1) XML 방식 : applicationConext.xml에 bean 등록
// (2) Annotation 방식 : @Aspect 어노테이션 등록
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		Person p = context.getBean("programmer", Person.class);
		p.coding();
	}
}
