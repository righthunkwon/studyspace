package com.ssafit.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.User;
import com.ssafit.board.model.service.ReviewService;
import com.ssafit.board.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-user") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags="유저 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class UserRestController {
	
	private UserService userService;
	
	@Autowired // 의존성 주입(생성자)
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	// (1) 회원가입
	@PostMapping("signup") // form 태그 형식으로 데이터가 넘어왔다고 가정
	@ApiOperation(value="유저 회원가입", notes="유저 회원가입")
	public ResponseEntity<Integer> signup(User user) {
		int result = userService.signUp(user);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// (2) 로그인
	@PostMapping("login")
	@ApiOperation(value="유저 로그인", notes="유저 로그인")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User tmp = userService.logIn(user.getUserId(),user.getPassword());
		// 로그인 실패 시 동작
		if(tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED); 
		}
		session.setAttribute("loginUser", tmp.getName());
		return new ResponseEntity<String>(tmp.getName(), HttpStatus.OK);
	}

	// (3) 로그아웃
	@GetMapping("logout")
	@ApiOperation(value="유저 로그아웃", notes="유저 로그아웃")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate(); // session.removeAttribute("loginUser");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}