package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.MyService;

@Controller
public class MyController {

	private MyService myService;
	
	@Autowired
	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
	@RequestMapping("home")
//	@RequestMapping(value="home", method = RequestMethod.GET)
	public ModelAndView homeHandle() {
		ModelAndView mav = new ModelAndView();
		myService.doSometing();
		
		// 데이터 저장(key-value 형태)
		mav.addObject("msg", "컨트롤러로부터 데이터 저장");
		
		// view 이름 지정
		// 포워딩과 동일한 기능
		mav.setViewName("home");
		return mav;
	}
	
	
	// Get요청 처리
	@GetMapping("test1")
	public String test1() {
		// 반환타입이 String 이라면 반환값이 viewname이 된다.
		return "test1"; // 반환값: /WEB-INF/view/test1.jsp
	}

	
	// Get요청 처리
	// Model을 활용하여 컨트롤러로부터 데이터 저장
	// 이때 반환은 request scope 안에서 처리된다.
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "컨트롤러로부터 데이터 저장");
		return "test2"; // 반환값: /WEB-INF/view/test2.jsp
	}
	
	
	// Get요청 처리
	// /WEB-INF/view/test3?id=아이디&pw=비밀번호 ... 
	// 클라이언트로부터 파라미터로 값을 받아 전송, 파라미터를 입력하지 않을 경우 기본값인 null 삽입
	// @GetMapping("test3") // 요청이 두 개면 에러 발생
	public String test3(Model model, String id, String pw) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "test3";
	}
	
	
	// Get요청 처리
	// /WEB-INF/view/test3?myid=아이디&pw=비밀번호 ...	
	// 클라이언트가 넘긴 파리미터의 키값이 내가 메소드로 작성한 값과 다르다면 
	// @RequestParam(value="myid") String id과 같이 myid를 id처럼 취급하여 받아올 수 있다.
	
	// age의 경우 기본 자료형인데,  
	// 만약 age의 value를 입력받지 않는다면 이것이 null로 처리되어 에러를 발생시킨다.
	
	// 따라서 age를 입력받지 않더라도 기본값을 지정하여 에러를 막아야 하는데, 
	// 이때 @RequestParam(defaultValue = "1") int age와 같이 기본값을 지정하여 에러를 방지할 수 있다.
	@GetMapping("test3")
	public String test3(Model model, @RequestParam(value="myid") String id, String pw, @RequestParam(defaultValue = "1") int age) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		return "test3";
	}
	
	
	// Post요청 처리
	@PostMapping("test4")
	public String test4(Model model, User user) {
		System.out.println(user); // 데이터가 넘어오는지 확인
		return "test4";
	}

}
