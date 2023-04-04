package com.campus.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardDeleteOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String userid = (String)request.getSession().getAttribute("logId");
		
		BoardDAO dao = new BoardDAO();
		int result = dao.boardDelete(no, userid);
		
		// 글내용보기 : no 필요
		request.setAttribute("no", no);
		request.setAttribute("cnt", result);
		return "/board/boardDelResult.jsp";
	}

}
