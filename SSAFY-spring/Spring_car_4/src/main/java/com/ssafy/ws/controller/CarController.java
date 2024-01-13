package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.ws.model.dto.Car;
import com.ssafy.ws.model.dto.User;

// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class CarController {

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
	 * <pre>
	 * /login 요청이 post 방식으로 왔을 때 login 처리한다.
	 * </pre>
	 * 
	 * 사용자의 요청에서 계정 정보를 추출해 로그인 처리한다. 일단 사용자 id가 ssafy, 비밀번호가 1234면 로그인에 성공으로 간주한다.
	 * 로그인 성공 시 session에 정보를 담고 redirect로 index로 이동한다. 그렇지 않을 경우는 로그인 실패 메시지를 model에
	 * 담고 forward로 index로 이동한다.
	 * 
	 * @param user    전달된 파라미터는 ModelAttribute를 통해서 객체로 받을 수 있다.
	 * @param session 사용자 정보를 세션에 저장하기 위해 사용한다.
	 * @param model   Request scope에 정보를 저장하기 위해서 사용된다.
	 * @return
	 */
	 @PostMapping("/login")
	 public String doLogin(HttpSession session, User user, Model model) {
	 	if (user.getId().equals("ssafy") && user.getPass().equals("1234")) {
	 		user.setName("김싸피");
	 		session.setAttribute("loginUser", user);
	 		return "redirect:/";
	 	} else {
	 		model.addAttribute("msg", "로그인 실패");
	 		return "index";
	 	}
	 }

	/**
	 * <pre>
	 * /logout을 get 방식으로 요청했을 때 session을 만료 시키고 로그아웃 처리한다.
	 * </pre>
	 * 
	 * 다음 경로는 redirect 형태로 /index로 이동한다.
	 * 
	 * @param session
	 * @return
	 */

	 @GetMapping("/logout")
	 public String doLogout(HttpSession session) {
	 	session.invalidate();
	 	return "redirect:/index";
	 }

	/**
	 * <pre>
	 * /list를 get 방식으로 요청할 때 도서 정보를 보여준다.
	 * </pre>
	 * 
	 * 아직 MVC의 model 영역을 완성하지 않았기 때문에 여러 개의 Car을 직접 생성해서 List 형태로 전달한다. 정보를 Model
	 * 객체에 저장 후 forward로 list를 호출한다.
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public String showList(Model model) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("1G1ZE5ST1HF199624", "말리부", "silver", 5000));
		cars.add(new Car("KMHXX00XXXX000000", "소나타", "white", 20000));
		cars.add(new Car("KMHXX00XXXX000001", "아반떼", "blue", 1000));
		model.addAttribute("cars", cars);
		return "list";
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
	 * '/regist' 요청이 post 방식으로 들어왔을 때 전달된 Car 객체를 regist_result로 연결한다.
	 * 
	 * @param car
	 * @return
	 */
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute Car car) {
		return "regist_result";

	}

}
