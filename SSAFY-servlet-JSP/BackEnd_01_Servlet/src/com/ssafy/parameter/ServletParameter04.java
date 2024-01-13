package com.ssafy.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletParameter04")
public class ServletParameter04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletParameter04() {
		super();
	}

	// form_04_gugu
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int dan = Integer.parseInt(request.getParameter("dan"));

		// 한글을 처리하기 위해 encoding 방식 지정 필요
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>구구단</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h1>" + dan + "단</h1>");
		for (int i = 1; i <= 9; i++) {
			writer.append("<div>" + dan + "*" + i + "=" + dan * i + "</div>");
		}
		writer.append("</body>");
		writer.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글을 처리하기 위해 encoding 방식 지정 필요
		request.setCharacterEncoding("UTF-8");
	}

}
