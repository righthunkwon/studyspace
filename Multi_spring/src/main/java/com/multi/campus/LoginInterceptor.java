package com.multi.campus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
	interceptor�� ó���� Ŭ��������
	�ݵ�� HandlerInterceptorAdapter�� ��ӹ޾ƾ� �Ѵ�.
*/
public class LoginInterceptor extends HandlerInterceptorAdapter {
	// (1) ��Ʈ�ѷ��� ȣ��Ǳ� ���� ����Ǵ� �޼ҵ�(���Ͽ����� �� �κи� ����)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// �α��� ������ Ȯ���ϰ� �α��� �� ��� ȣ���� �����ּҷ� �̵���Ű��, �α����� �� �� ��� �α��������� �̵���Ų��.
		HttpSession session = request.getSession();
		String logId = (String)session.getAttribute("logId");
		String logStatus = (String)session.getAttribute("logStatus");
		if(logStatus == null || !logStatus.equals("Y")) {
			response.sendRedirect(request.getContextPath()+"/loginForm");
			return false;
		}
		// ��ȯ���� false�̸� ������ �����ϰ�, true�̸� ������ �����Ѵ�.
		return true;
	}
	// (2) ��Ʈ�ѷ� ���� �� View�� �̵��ϱ� ���� ����Ǵ� �޼ҵ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			@Nullable ModelAndView mav) throws Exception {
		
	}
	// (3) ��Ʈ�ѷ� ���� �� ȣ��Ǵ� �޼ҵ�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
	}
}
