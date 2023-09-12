package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Spring을 통한 개발
		ApplicationContext context = new  GenericXmlApplicationContext("applicationContext.xml");
		
		Programmer p = (Programmer) context.getBean("programmer");
		Desktop d = (Desktop) context.getBean("desktop");
		Laptop l = (Laptop) context.getBean("laptop");
		
//		Programmer p = context.getBean("programmer", Programmer.class);
//		Desktop d = (Desktop) context.getBean("desktop", Desktop.class);
//		Laptop l = (Laptop) context.getBean("laptop", Laptop.class);
		
		
		// 싱글톤 패턴으로 가져오는 것임을 확인
		Desktop d1 = (Desktop) context.getBean("desktop");
		Desktop d2 = (Desktop) context.getBean("desktop");
		System.out.println(d1 == d2); // true

	}

}
