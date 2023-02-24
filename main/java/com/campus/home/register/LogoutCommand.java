package com.campus.home.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class LogoutCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 : 세션 제거 이후 홈페이지로 이동
		// 세션 제거
		request.getSession().invalidate();
		// 홈페이지로 이동
		return "index.jsp";
	}

}
