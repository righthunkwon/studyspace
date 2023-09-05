package com.ssafy.parameter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 자바에서의 /는 직전 / 이후에 요소를 붙게 하여 기존재 존재하던 context root 등이 살아있지만,
// HTML에서의 /는 port 번호 이후에 경로를 붙게 하여 기존에 존재하던 context root등 을 삭제한다. 
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html charset=UTF-8");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// (1) get 요청 시
		// doGet에서 response를 UTF-8로 바꾸고
		// doProcess 실행

		// (2) post 요청 시
		// doPost에서 request를 UTF-8로 바꾸고
		// doGet에서 response를 UTF-8로 바꾸고
		// doProcess 실행

		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doSignUp(request, response);
			break;
		case "gugu":
			doGugu(request, response);
			break;
		default:
			break;
		}
	}

	protected void doSignUp(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 실행
	}

	private void doGugu(HttpServletRequest request, HttpServletResponse response) {
		// 구구단 실행
	}

}
