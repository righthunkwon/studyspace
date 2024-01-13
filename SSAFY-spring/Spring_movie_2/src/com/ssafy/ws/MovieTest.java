package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) throws CallException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		Person p = context.getBean("audience", Person.class);
		p.doSomething();
	}
}