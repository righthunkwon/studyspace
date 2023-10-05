package com.ssafy.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Dispatcher Servlet
// web인 요소는 src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml에 설정 파일이 있고,
// web이 아닌 요소는 src/main/webapp/WEB-INF/spring/root-context.xml에 설정 파일이 있다.

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	// 컨트롤러에서 로그인의 유무에 따라 요청을 처리하고 싶은데,
	// 그렇게 하기 위해서는 모든 메소드마다 로그인 유무를 파악하는 코드를 넣어줘야 한다.
	// 이러한 문제를 해결하고자 인터셉터가 등장하였고, 인터셉터를 통해 로그인 유무를 먼저 파악할 수 있다.
	
	@GetMapping("regist") // regist라는 Get요청이 들어왔을 때 regist.jsp로 연결
	public String registForm() {
		return "regist";
	}
	
	@PostMapping("regist")
	public String regist() {
		// 서비스 호출 후 등록 
		return "index";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}
	
	
	@PostMapping("login")
	public String login(HttpSession session, String id,  String pw) {
		// 원래는 user 관련 service를 호출해서 직접 내 사용자가 맞는지 확인 필요
		if(id.equals("ssafy") && pw.equals("1234")) {
			session.setAttribute("id", id);
			return "redirect:/";
		}
		
		// 정상적인 유저아 아니라면 로그인 페이지로 다시 전송 
		return "redirect:/login";
	}
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		// 로그아웃 하는 방법 두 가지 
		// 1) 아이디 삭제 session.removeAttribute("id");
		// 2) 세션 초기화 session.invalidate();
		
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
