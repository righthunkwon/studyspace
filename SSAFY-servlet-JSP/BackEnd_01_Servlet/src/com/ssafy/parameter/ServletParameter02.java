package com.ssafy.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletParameter02")
public class ServletParameter02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletParameter02() {
		super();
	}

	// form_02_input_text
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("text");
		
		// 한글을 처리하기 위해 encoding 방식 지정 필요
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>Hello</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h1>" + text + "</h1>");
		writer.append("</body>");
		writer.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글을 처리하기 위해 encoding 방식 지정 필요
		request.setCharacterEncoding("UTF-8");
	}

}
