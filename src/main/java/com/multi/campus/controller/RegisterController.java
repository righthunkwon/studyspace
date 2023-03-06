package com.multi.campus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;
import com.multi.campus.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterService service;
	
	// 로그인폼
	@GetMapping("/loginForm")
	public String login() {
		return "register/loginForm"; // WEB-INF/views/register/loginForm.jsp
	}
	
	// 로그인(DB)
	@PostMapping("/loginOk")
	public ModelAndView loginOk(String userid, String userpwd, HttpServletRequest request, HttpSession session) {
		System.out.println("userid->"+userid);
		RegisterDTO dto = service.loginOk(userid, userpwd);
		// 선택레코드가 없을 경우 dto가 null이 되어 로그인에 실패한다.
		// 선택레코드가 있을 경우에는 로그인이 성공한다.
		ModelAndView mav = new ModelAndView();
		if(dto!=null) { // 로그인 성공
			session.setAttribute("logId", dto.getUserid());
			session.setAttribute("logName", dto.getUsername());
			session.setAttribute("logStatus", "Y");
			mav.setViewName("redirect:/");
		} else { // 로그인 실패
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	
	// 로그아웃(세션 제거)
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	// 회원가입 폼
	@GetMapping("/join")
	public String join() {
		return "register/join";
	}
	
	// 아이디 중복검사 폼
	@GetMapping("/idCheck")
	public String idCheck(String userid, Model model) {
		// DB 조회 -> 아이디의 개수 확인(0 또는 1)
		int result = service.idCheckCount(userid);
		
		// 뷰에서 사용하기 위해 모델에 세팅
		model.addAttribute("userid", userid);
		model.addAttribute("result", result);
		
		return "register/idCheck";
	}
	
	// 우편번호 검색
	@RequestMapping(value="/zipcodeSearch", method=RequestMethod.GET)
	public ModelAndView zipcodeSearch(String doroname) {
		ModelAndView mav = new ModelAndView();
		// 선택한 주소가 없으면 return은 null
		List<ZipcodeDTO> zipList = null;
		if(doroname!=null) { 
			zipList = service.zipSearch(doroname);
		}
		mav.addObject("zipList", zipList);
		mav.setViewName("register/zipcodeSearch");
		return mav;
	}
}
