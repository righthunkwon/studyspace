package com.ssafy.mvc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MyFilter2 implements Filter {

	public MyFilter2() {
	}

	// 필터 초기화 메소드
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	// 필터 동작 처리 메소드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 서블릿 동작 이전에 동작할 코드
		System.out.println("서블릿 동작 이전에 할것2");
		
		// 필터체인에 다음 필터가 존재하면 다음 필터로 넘어아고, 다음 필터가 없으면 서블릿 호출
		chain.doFilter(request, response); 
		
		// 서블릿 동작 이후에 동작할 코드
		System.out.println("서블릿 동작 이후에 할것2");

	}
	
	// 필터 종료 메소드
	public void destroy() {
		
	}
}
