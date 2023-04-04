package com.campus.home.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardListCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB에서 레코드를 선택(DAO에서 결과값이 넘어옴)
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardAllSelect();
		
		// request에 뷰에서 사용할 정보를 세팅 
		request.setAttribute("list", list);
		return "/board/boardList.jsp";
	}

}
