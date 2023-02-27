package com.campus.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardEditCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// no를 가져온다.
		int no = Integer.parseInt(request.getParameter("no"));
		
		// DB 조회
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.oneBoardSelect(no);
		
		// 수정 폼으로 이동
		request.setAttribute("dto", dto);
		
		return "/board/boardEdit.jsp";
	}

}
