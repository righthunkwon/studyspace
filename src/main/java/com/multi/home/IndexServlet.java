package com.multi.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 클래스는 HttpServlet을 상속받는다.
@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
       
    public IndexServlet() {
        super();
    }

    // get 방식 접속 또는 post 방식으로 접속을 하면 doGet() 혹은 doPost()가 실행되기 전에 먼저 실행
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()메소드 실행");
	}

	// 클라이언트가 서버에 get 방식으로 접속하면 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메소드 실행");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>홈페이지</title></head><body>");
		pw.println("<h2><a href='/webServlet/login.do'>로그인</a></h2>");
		pw.println("<h2><a href=''>로그아웃</a></h2>");
		pw.println("</body></html>");
	}
	// 클라이언트가 서버에 post 방식으로 접속하면 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 접속이 좋료되면 실행되는 메소드
	public void destroy() {
	
	}
}
