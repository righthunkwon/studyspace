package com.ssafy.myservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Servlet 인터페이스를 활용하는 방법
// 해당 클래스를 서블릿으로 만들기 위해서는 서블릿 인터페이스를 구현해야 한다(클래스를 구현 클래스로 만들어야 한다).
public class MyServlet1 implements Servlet {

	@Override
	public void destroy() {
		// 서블릿 소멸: destroy
	}

	@Override
	public ServletConfig getServletConfig() {
		// 서블릿 설정 반환: getServletConfig
		return null;
	}

	@Override
	public String getServletInfo() {
		// 서블릿 정보 문자열 반환: getServletInfo
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 초기화: init
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 요청과 응답 처리: service
	}

}
