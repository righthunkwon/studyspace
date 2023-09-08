package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.ws.step2.dto.Movie;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	// serialVersionUID
	private static final long serialVersionUID = 1L;
	
	// 등록한 영화 개수를 저장하는 ArrayList
	private static List<Movie> movieList = new ArrayList<>();

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
		case "list":
			doList(request, response);
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

		// 전달받은 파라미터를 바탕으로 영화 객체를 생성
		Movie movie = new Movie(title, director, genre, runningTime);
		
		// movieList에 영화 추가
		movieList.add(movie);
		
		// 영화 객체를 request에 등록
		request.setAttribute("movie", movie);
		request.setAttribute("movies", movieList);
		request.setAttribute("movieCount", movieList.size());
		
		// JSP 페이지로 이동하기 위해 RequestDispatcher의 forward 방식을 사용한다.
		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
		disp.forward(request, response);
	}
	
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// attribute에 지금까지 등록한 영화 리스트와 영화의 수를 등록
		request.setAttribute("movies", movieList);
		request.setAttribute("movieCount", movieList.size());
		
		// forward를 통해 list.jsp 호출
		RequestDispatcher disp = request.getRequestDispatcher("/list.jsp");
		disp.forward(request, response);
	}
}
