package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.ws.model.dto.Movie;

// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class MovieController {
		
	/**
	 * '/' 또는 '/index' 요청이 get 방식으로 들어왔을 때 index로 연결한다.
	 * @return
	 */
	@GetMapping({"/", "/index" })
	public String showIndex() {
		return "index";
	}
	
	/**
	 * '/regist' 요청이 get 방식으로 들어왔을 때 regist로 연결한다.
	 * @return
	 */
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	/**
	 * '/regist' 요청이 post 방식으로 들어왔을 때 전달된 Movie 객체를 regist_result로 연결한다. 
	 * @param movie
	 * @return
	 */
	@PostMapping("/regist")
	public String doRegist(Movie movie) {
		return "regist_result";
	}
	 
}
