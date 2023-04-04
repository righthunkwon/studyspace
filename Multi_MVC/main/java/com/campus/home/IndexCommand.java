package com.campus.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements CommandService {
	@Override
	public String processStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("홈페이지 커맨드 실행");
		return "index.jsp"; // view 페이지 명을 리턴(.jsp파일)
	}
}
