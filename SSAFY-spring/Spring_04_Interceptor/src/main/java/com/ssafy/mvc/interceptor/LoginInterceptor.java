package com.ssafy.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

// 인터셉터는 HandlerInterceptor 인터페이스를 구현하는 걸 권장
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null) {
			response.sendRedirect("login");
			return false; // 요청 실패
		}
		return true; // 요청 승인
	}
	

}
