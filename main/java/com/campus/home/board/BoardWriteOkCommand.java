package com.campus.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardWriteOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 이전(값을 가져오기 이전)에 한글 파일 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		// 값 가져오기
		BoardDTO dto = new BoardDTO();
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		
		// 세션의 글쓰기 가져오기
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		dto.setIp(request.getRemoteAddr());
		
		// DB 등록
		BoardDAO dao = new BoardDAO();
		int result = dao.boardInsert(dto);
		request.setAttribute("result", result);
		
		// 페이지 이동(등록:list, 실패:history.back) -> jsp 뷰페이지를 만들어 해당 페이지로 이동시킴으로써 구현
		return "/board/boardWriteResult.jsp";
	}

}
