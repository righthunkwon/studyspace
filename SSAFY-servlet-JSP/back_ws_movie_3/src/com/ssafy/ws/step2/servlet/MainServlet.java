package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	// serialVersionUID
	private static final long serialVersionUID = 1L;
	
	// 등록한 영화 개수 저장
	private static int movieCount = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		// Front-Controller 방식을 활용하기 위해
		// 다양한 요청이 들어오는 걸 구분하고자 value 속성에 따라 메소드 호출
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request 객체에서 전달된 parameter를 추출한다.
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));

		// 상단에 static으로 movieCount 저장
		// 세션에 지금까지 등록된 영화 수를 저장하고 영화 수를 하나 증가시킨다.
		HttpSession session = request.getSession();
		session.setAttribute("movieCount", ++movieCount);
		
		// 전달받은 파라미터를 request에 담는다.
		request.setAttribute("title", title);
		request.setAttribute("director", director);
		request.setAttribute("genre", genre);
		request.setAttribute("runningTime", runningTime);

		// JSP 페이지로 이동하기 위해 RequestDispatcher의 forward 방식을 사용한다.
		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
		disp.forward(request, response);
	}
}
