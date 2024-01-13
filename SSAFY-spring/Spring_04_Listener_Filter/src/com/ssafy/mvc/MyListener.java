package com.ssafy.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    public MyListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 종료가 될때 호출 될 친구");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 시작될때 호출 될 친구");
    }
	
}
