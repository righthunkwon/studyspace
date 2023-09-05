package com.ssafy.myservlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Generic Servlet 추상 클래스를 활용하는 방법
// Servlet 인터페이스와 달리 모든 메소드를 재정의할 필요가 없다.
public class MyServlet2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Generic 서블릿 추상 클래스에서는 요청과 응답만 처리하는 service 메소드만 재정의하면 된다.
	}


}
