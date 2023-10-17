package com.ssafy.board.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	// 의존성 주입
	private BoardService service = BoardServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET요청에서는 안했지만 POST 요청에서는 인코딩 방식을 바꿔~
		if (request.getMethod().equals("POST"))
			request.setCharacterEncoding("UTF-8");

		String act = request.getParameter("act");

		switch (act) {
		case "list":
			doList(request, response);
			break;
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		default:
			break;
		}

	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		service.removeBoard(id);
		response.sendRedirect("board?act=list");
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Board board = new Board();
		board.setId(id);
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);

		service.modifyBoard(board);
		response.sendRedirect("board?act=list");

	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Board board = service.getBoard(id);
			request.setAttribute("board", board);
			request.getRequestDispatcher("/board/updateform.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			request.setAttribute("board", service.getBoard(id));
			request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Board board = new Board(title, writer, content);

		service.writeBoard(board);

		response.sendRedirect("board?act=list");

	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/writeform.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스호출 -> Dao 호출 -> list.jsp 포워딩
		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);

	}
}
