package com.campus.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Command 클래스를 만들 때 메소드명을 통일시키기 위해서 생성한 인터페이스
public interface CommandService {
	
	public String processStart(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException;
	
}