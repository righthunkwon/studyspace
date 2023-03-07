package com.multi.campus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// Controller : 뷰단 언어 사용 불가, 스크립트 필요 시 jsp 파일을 생성 후 구현
// RestController : 프론트언어를 백엔드에서 기술할 수 있는 기능 제공, 반환형을 String으로 하면 뷰페이지 파일명이 아니라 컨텐츠 내용으로 처리한다
@RestController
public class BoardController {
	@GetMapping("/board/boardList")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		// DB 조회
		mav.setViewName("board/boardList");
		return mav;
	}
}
