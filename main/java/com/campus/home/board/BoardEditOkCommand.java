package com.campus.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardEditOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO dto = new BoardDTO();
		
		// 폼의 값을 서버로 가져오기(글번호, 수정한 글제목, 수정한 글내용)
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		
		// 세션의 값을 서버로 가져오기(글쓴이 아이디)
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		
		// DB 업데이트
		BoardDAO dao = new BoardDAO();
		int result = dao.boardUpdate(dto);
		
		// 수정 완료 시 글 내용 보기(no), 수정 안될 시 글 수정폼으로(history.back()) 
		request.setAttribute("result", result);
		request.setAttribute("no", dto.getNo());
		return "/board/boardEditResult.jsp";
	}

}
