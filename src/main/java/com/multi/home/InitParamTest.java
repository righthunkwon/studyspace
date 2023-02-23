package com.multi.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/init.do")
public class InitParamTest extends HttpServlet {
	String userid;
	String username;
	
    public InitParamTest() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		// web.xml의 <init-param>의 데이터를 가져오기 : getInitParameter (상속받은 HttpServlet의 메소드)
		userid = config.getInitParameter("userid");
		username = config.getInitParameter("username");
		
		System.out.println("userid="+userid+", username="+username);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ContentType 세팅하기
		response.setContentType("text/html; charset=UTF-8");
		
		// 접속자의 웹브라우저로 서버에서 응답하기
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>서블릿 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>아이디: "+userid+"</p>");
		pw.println("<p>이름: "+username+"</p>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
