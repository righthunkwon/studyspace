package com.ssafy.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class MyListener2 implements ServletContextListener {

	// @WebListener
	// 어노테이션을 사용하지 않을 경우
	// WebContent/WEB-INF/web.xml에서 리스너를 등록할 수 있다.
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 종료가 될때 호출 될 친구2");
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹어플리케이션이 시작될때 호출 될 친구2");
    	
    	// ServletContextEvent 내부에 있는 객체를 미리 가져오는 코드
    	ServletContext context = sce.getServletContext();
    	System.out.println(context.getInitParameter("welcome"));
    }
	
}
