package com.ssafy.hw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.hw.model.dto.User;

// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class UserController {

	/**
	 * '/' 또는 '/index' 요청이 get 방식으로 들어왔을 때 index로 연결한다.
	 * 
	 * @return
	 */
	@GetMapping({ "/", "/index" })
	public String showIndex() {
		return "index";
	}

	/**
	 * '/regist' 요청이 get 방식으로 들어왔을 때 regist로 연결한다.
	 * 
	 * @return
	 */
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	/**
	 * '/regist' 요청이 post 방식으로 들어왔을 때 전달된 User 객체를 regist_result로 연결한다.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/regist")
	public String doRegist(User user, Model model) {
		// 전달할 객체
		model.addAttribute("user", user);
		return "/regist_result";
	}

	/**
	 * '/list' 요청이 get 방식으로 들어왔을 때 User List를 Model에 담아서 list로 연결한다.
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public void showList(Model model) {
		// 아직 DB에 연결하지 않았으므로 임의로 사용자 정보 4개를 생성해서 list에 담아 전달한다.
		List<User> list = new ArrayList<User>();
		list.add(new User("ssafy1", "1234", "김싸피", "ssafy1@ssafy.com", 26));
		list.add(new User("ssafy2", "1234", "박싸피", "ssafy2@ssafy.com", 26));
		list.add(new User("ssafy3", "1234", "이싸피", "ssafy3@ssafy.com", 26));
		list.add(new User("ssafy4", "1234", "강싸피", "ssafy4@ssafy.com", 26));

		model.addAttribute("users", list);
	}

	/**
	 * '/login' 요청이 post 방식으로 들어왔을때 로그인 처리를 한다.
	 * 
	 * 일단 사용자 id가 ssafy, 비밀번호가 1234 이면 로그인에 성공한 것으로 간주한다. 로그인 성공시 session에 사용자 정보를
	 * 담고 redirect를 통해 index.jsp로 이동한다. 로그인 실패시 로그인 실패 메시지를 model에 담고 forward를 통해
	 * index.jsp로 이동한다.
	 * 
	 * @param user    로그인 요청한 사용자 정보
	 * @param session 사용자 정보를 저장하기 위해 세션 사용
	 * @param model   Request scope 에 정보를 저장, view 에 전달하기 위해 사용
	 * @return 사용자에게 보여줄 페이지
	 */
	@PostMapping("/login")
	public String doLogin(User user, HttpSession session, Model model) {
		String view = "/index";

		if (user.getId().equals("ssafy") && user.getPassword().equals("1234")) {
			user.setName("김싸피");
			session.setAttribute("loginUser", user);
			view = "redirect:/";
		} else {
			model.addAttribute("msg", "로그인 실패");
		}
		return view;
	}

	/**
	 * '/logout' 요청이 get 방식으로 들어왔을때 로그아웃 처리를 한다.
	 * 
	 * session을 만료시키고 redirect를 통해 / 로 이동한다.
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/**
	 * '/error/404' 요청이 get 방식으로 들어왔을때 보여줄 페이지 매핑된 주소를 처리하는 메서드가 존재하지 않을시 표시할 에러
	 * 페이지이다.
	 */
	@GetMapping("/error/404")
	public void showError404() {
		// 404 Not Found 처리
	}
}
