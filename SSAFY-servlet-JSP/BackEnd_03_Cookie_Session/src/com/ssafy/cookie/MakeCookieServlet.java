package com.ssafy.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makeCookie")
public class MakeCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public MakeCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		// 데이터 잘 넘어오는지 확인
		System.out.println(username);
		System.out.println(content);
		
		// 쿠키 생성
		// Cookie의 파라미터로는 key와 value가 순서대로 온다.
		// 하단의 쿠키에서 유저이름이 key고 내용이 value이다.
		// 쿠키는 개발자도구의 Application에서 확인할 수 있다
		// URLEncoder를 활용하여 쿠키값을 인코딩하면 한글값을 받을 수 있다.
		Cookie cookie = new Cookie(URLEncoder.encode(username, "UTF-8") , URLEncoder.encode(content, "UTF-8") );
		
		// 쿠키의 유효기간 설정(단위: 초)
		cookie.setMaxAge(5); 
		
		// 쿠키를 response에 담아 서버에서 클라이언트에게 보낸다.
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
