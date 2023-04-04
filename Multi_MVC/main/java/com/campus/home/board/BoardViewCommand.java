package com.campus.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardViewCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no")); 
		
		BoardDAO dao = new BoardDAO();
		
		// 조회수 증가
		dao.hitCount(no);
		// no에 해당하는 레코드를 선택한 뒤 dto를 담아 리턴
		BoardDTO dto = dao.oneBoardSelect(no);
		request.setAttribute("boardDTO", dao.oneBoardSelect(no));
		
		return "/board/boardView.jsp";
	}

}
