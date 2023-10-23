package com.ssafy.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

@RestController
@RequestMapping("/rest4")
public class TestController4 {
	
	// REST API에서 상세보기 페이지(ex. 글번호(id)가 99인 글을 조회)를 들어갈 때는
	// URI 뒤에 ?id=99를 붙이는 방식으로 들어가는 것이 아니라 단순히 id 번호를 넣으면 된다.
	
	// (1) GET
	// http://localhost:8080/mvc/rest4/board/99
	@GetMapping("/board/{id}")
	public String test1(@PathVariable int id) {
		return id + " : good!!!";
	}
	
	// 위와 동일한 코드(no가 id와 동일함을 파라미터를 이용해서 명시)
//	@GetMapping("/board/{id}")
//	public String test1(@PathVariable("id") int no) {
//		return no + " : good!!!";
//	}
	

	// (2) POST
	// 게시글 등록(POST, 폼 형태)
	// application/x-www-form-urlencoded
	// http://localhost:8080/mvc/rest4/board
//	@PostMapping("/board")
//	public String test2(User user) {
//		return user.toString();
//	}
	
	
	// JSON 형태로 데이터 전송
//	{
//		"name" : "kwon",
//		"id"   : "ssafy",
//		"password" : "12345"
//	}
	
	// 게시글 등록(POST, JSON 형태)
	// http://localhost:8080/mvc/rest4/board
	@PostMapping("/board")
	public String test3(@RequestBody User user) {
		return user.toString();
	}
	
	// (참고) ResponseEntity
	// 데이터 응답 시 상태코드, 헤더, 데이터 설정 가능
	// http://localhost:8080/mvc/rest4/test4
	@GetMapping("/test4")
	public ResponseEntity<String> test4(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "admin");
		return new ResponseEntity<String>("OK data", headers, HttpStatus.OK);
	}
	
}