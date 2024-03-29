package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.ws.step2.dto.Movie;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
		int id = 777;
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));

		// 전달받은 parameter를 이용해서 Car 객체를 생성한다.
		Movie movie = new Movie(id, title, director, genre, runningTime);

		// 화면에 출력할 데이터를 구성한다.
		StringBuilder output = new StringBuilder();

		output.append("<html><body>").append("<h1>자동차 정보</h1>").append(movie.toString()).append("</body></html>");

		// response 객체를 통해서 생성한 html코드를 출력한다.
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());
	}
}
