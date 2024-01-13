package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) throws ApplicationException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		User u1 = context.getBean("generalUser", User.class);
		User u2 = context.getBean("adminUser", User.class);
		System.out.println("******1.GeneralUser");
		u1.useApp();
		System.out.println("******2.AdminUser");
		u2.useApp();
	}

}
