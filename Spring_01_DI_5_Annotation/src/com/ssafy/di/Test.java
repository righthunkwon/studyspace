package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Spring을 통한 개발
		ApplicationContext context = new  GenericXmlApplicationContext("applicationContext.xml");
		
		Programmer p = (Programmer) context.getBean("programmer");
		p.coding();
	}

}
