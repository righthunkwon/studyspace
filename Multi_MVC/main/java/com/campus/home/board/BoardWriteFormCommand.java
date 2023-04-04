package com.campus.home.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class BoardWriteFormCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/board/boardWriteForm.jsp";
	}

}
