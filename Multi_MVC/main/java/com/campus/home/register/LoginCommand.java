package com.campus.home.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campus.home.CommandService;

public class LoginCommand implements CommandService {

	@Override
	public String processStart(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		
		return "register/loginForm.jsp";
	}

}
