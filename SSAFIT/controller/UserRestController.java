package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api-user") // 반복되는 상위 경로 적용
@Api(tags="유저 컨트롤러") // 이름
// @CrossOrigin("*") -> WebConfig에서 설정
public class UserRestController {
	
	// UserService 의존성 주입
	@Autowired
	private UserService userService;
	
	// (1) 전체 유저 조회
	@GetMapping("users")
	public List<User> userList() {
		return userService.getUserList();
	}
	
	// (2) 유저 등록(회원가입)
	// form -> @RequestBody 필요 없음
	// json -> @RequestBody 붙여야 함
	@PostMapping("signup")
	public ResponseEntity<Integer> signup(User user) {
		// result가 0이면 등록 X - 프론트에서 가입 실패라는 메시지 출력
		// result가 1이면 등록 O - 프론트에서 가입 성공이라는 메시지 출력
		int result = userService.signup(user);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	// (3) 로그인
	// 과거에는 메인 페이지 내에 로그인 창이 있는 경우가 대부분이었지만,
	// 현재에는 로그인 페이지가 별도로 구성되는 경우가 많다(보안 문제).
	@PostMapping("login")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User tmp = userService.login(user);
		// 로그인 실패
		if(tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		
		// 로그인 성공
		session.setAttribute("loginUser", tmp.getName());
		return new ResponseEntity<String>(tmp.getName(), HttpStatus.OK);
	}
	
	// (4) 로그아웃
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}