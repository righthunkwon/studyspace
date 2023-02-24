package com.campus.home.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campus.home.CommandService;

public class LoginOkCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterDTO dto = new RegisterDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setUserpwd(request.getParameter("userpwd"));
		
		RegisterDAO dao = new RegisterDAO();
		RegisterDTO dtoResult = dao.login(dto);
		
		String viewname = null;
		if(dtoResult.getUserid()!=null && dtoResult.getUsername()!=null) { // 로그인 성공 "index.jsp"
			HttpSession session = request.getSession();
			session.setAttribute("logId", dtoResult.getUserid());
			session.setAttribute("logName", dtoResult.getUsername());
			
			// 로그인 성공시 view
			viewname = "index.jsp";
			
		} else { // 로그인 실패 "loginForm.jsp"
			viewname = "register/loginForm.jsp";
		}
		return viewname;
	}

}
