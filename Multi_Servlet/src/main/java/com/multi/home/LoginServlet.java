package com.multi.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><head><title>로그인 폼</title></head><body>");
		pw.println("<h1>로그인</h1>");
		pw.println("<form method='post' action='/webServlet/loginOk.do'>");
		pw.println("아이디: <input type='text' name='userid'/><br/>");
		pw.println("비밀번호: <input type='text' name='userpwd'/><br/>");
		pw.println("<input type='submit' value='Login'/></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인DB
	}

}
