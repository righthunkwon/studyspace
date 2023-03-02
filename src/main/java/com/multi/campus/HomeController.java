package com.multi.campus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // annotation : Controller, RestController
public class HomeController {
	
	// Controller는 접속을 받아 이를 View로 넘겨준다.
	
	// (1) localhost:9090/campus/
	@RequestMapping(value = "/", method = RequestMethod.GET) // get 방식 접속(접속주소: /)
	public String home(Model model) { // Model 을 활용하여 접속
		model.addAttribute("num", 123);
		model.addAttribute("name", "모델데이터");
		return "home";
	}
	
	// (2) localhost:9090/campus/test?name=권
	// : request 객체를 활용한 방법
	@RequestMapping("/test") // get 방식 접속의 다른 형태(접속주소: /test)
	public ModelAndView test(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("test(이름):"+name);
		
		// ModelAndView : 데이터와 뷰 페이지 정보를 함께 가지는 클래스
		ModelAndView mav = new ModelAndView();
		
		// 데이터 세팅
		mav.addObject("num", 456);
		mav.addObject("name", name);
		
		// 뷰 페이지 세팅
		mav.setViewName("home");
		
		return mav;
	}
	
	// (3) localhost:9090/campus/test2?addr=서울시
	// : 매개변수로 넣어주는 방법
	@RequestMapping("/test2") // get 방식 접속의 또 다른 형태(접속주소: /test2)
	public ModelAndView test2(String addr) {
		System.out.println("test2(주소):"+addr);
		
		// 매핑에서 다른 매핑으로 이동하는 방법
		// (/test2 를 처리한 후 /test3 매핑 주소로 이동하도록 구현)
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", 789);
		mav.addObject("name", "test2");
		// 접속할 다른 컨트롤러의 매핑주소 입력(redirect:주소)
		mav.setViewName("redirect:test3");
		return mav;
	}
	
	// (4) localhost:9090/campus/test3?num=100&name=권정훈
	// : DTO를 활용하는 방법
	@RequestMapping("/test3") // get 방식 접속의 또 다른 형태(접속주소: /test3)
	public String test3(TestDTO dto, Model model) { // DTO를 사용할 때는 메소드 이름을 바꿔도 관계 없다(RequestMapping은 /test3이어야 한다).
		System.out.println("test3(숫자):"+(dto.getNum()+456000));
		System.out.println("test3(이름):"+(dto.getName()));
		System.out.println(dto.toString());
		model.addAttribute("num", 123456789);
		model.addAttribute("name", "test3");
		return "home";
	}
	
	// (5) localhost:9090/campus/test4?tel=010-1234-5678
	@GetMapping("/test4") // get 방식 접속의 또 다른 형태(접속주소: /test4)
	// (참고) @PostMapping("/test4") // post 방식 접속
	public String test4(String tel) {
		System.out.println("test4(연락처):"+tel);
		return "home";
	}
	
}
