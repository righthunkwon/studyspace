package com.ssafy.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


// 인터셉터 등록
// servlet-context.xml에 인터셉터 등록

// 인터셉터로 만드는 방법 
// 1) 구현 : implements HandlerInterceptor(권장)
// 2) 상속 : extends HandlerInterceptorAdapter

// 인터셉터의 세 가지 메소드
// 1) preHandle
// 2) postHandel
// 3) afterCompletion

// A, B, C의 인터셉터 실행 순서
// A의 preHandle, B의 preHandle C의 preHandle
// C의 postHandle, B의 postHandle, A의 postHandle,
// C의 afterCompletion, B의 afterCompletion, A의 afterCompletion
public class AInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("A의 preHandle");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("A의 postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("A의 afterCompletion");
	}

}
