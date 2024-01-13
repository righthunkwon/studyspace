package com.ssafy.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

// 실제 프로젝트를 수행할 때는
// 컨트롤러 생성 - > 서비스 생성 -> 서비스 구현 클래스(impl) 생성 
// -> DAO 생성 -> DAO 구현 클래스(impl 혹은 Mybais 이용시 mapper.xml) 생성

@Controller // 컨트롤러를 스프링 빈으로 등록 
public class UserController {
	
	// @Autowired
	// 필드, 생성자, 설정자에 의존성 주입 가능
	
	@Autowired // 필드로 컨트롤러에 서비스 의존성 주입(유저 컨트롤러에 유저 서비스 의존성 주입)
	private UserService userService;
	
	@GetMapping("users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/userList";
	}
	
	@GetMapping("signup")
	public String signupForm() {
		return "/user/signupform";
	}
	
	@PostMapping("signup")
	public String signup(User user) {
//		System.out.println(user); // 디버깅
		userService.signup(user);
		return "redirect:list";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("login")
	public String login(User user, HttpSession session) {
		User u = userService.login(user);
		// 로그인 실패
		// 로그인 실패 시 다시 로그인 페이지로 보냄
		if(u == null) return "redirect:login";
		
		// 로그인 성공
		session.setAttribute("loginUser", u.getName());
		return "redirect:list";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		// 로그아웃의 두 가지 방법
		session.invalidate(); // 로그아웃(1)
//		session.removeAttribute("loginUser"); // 로그아웃(2)

		
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}