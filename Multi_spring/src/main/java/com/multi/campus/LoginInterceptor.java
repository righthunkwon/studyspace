package com.multi.campus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
	interceptor를 처리할 클래스에는
	반드시 HandlerInterceptorAdapter를 상속받아야 한다.
*/
public class LoginInterceptor extends HandlerInterceptorAdapter {
	// (1) 컨트롤러가 호출되기 전에 실행되는 메소드(파일에서는 이 부분만 구현)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 로그인 유무를 확인하고 로그인 된 경우 호출한 매핑주소로 이동시키고, 로그인이 안 된 경우 로그인폼으로 이동시킨다.
		HttpSession session = request.getSession();
		String logId = (String)session.getAttribute("logId");
		String logStatus = (String)session.getAttribute("logStatus");
		if(logStatus == null || !logStatus.equals("Y")) {
			response.sendRedirect(request.getContextPath()+"/loginForm");
			return false;
		}
		// 반환형이 false이면 매핑을 변경하고, true이면 매핑을 지속한다.
		return true;
	}
	// (2) 컨트롤러 실행 후 View로 이동하기 전에 실행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			@Nullable ModelAndView mav) throws Exception {
		
	}
	// (3) 컨트롤러 실행 후 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
	}
}
