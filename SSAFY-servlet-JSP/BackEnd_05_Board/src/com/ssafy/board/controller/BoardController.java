package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

// 흐름
// Controller - Service - DAO - DB - DAO - Service - Controller - View(JSP)

@WebServlet("/board")
public class BoardController extends HttpServlet {

	// 의존성 주입(Autowired)
	private BoardService service = BoardServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// post 방식일 때는 인코딩 설정
		// get 방식은 jsp에 다시 보내지므로 그때 인코딩이 되어 별도 설정 불필요
		if (req.getMethod().equals("POST")) {
			req.setCharacterEncoding("UTF-8");
		}

		String act = req.getParameter("act");
		switch (act) {
		case "list":
			doList(req, res);
			break;
		case "writeform":
			doWriteForm(req, res);
			break;
		default:
			break;
		}
	}

	private void doWriteForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/board/writeform.jsp").forward(req, res);
	}

	private void doList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 흐름
		// Controller - Service - DAO - JSP (Forward)
		req.setAttribute("list", service.getList());
		req.getRequestDispatcher("/board/list.jsp").forward(req, res);
	}
}
