package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.User;

// @Controller를 @RestController로 지정할 경우
// 별도로 요청마다 @ResponseBody를 붙여서 반환값이 페이지가 아니라 데이터임을 명시하지 않아도 
// 자동으로 반환값을 데이터로 인식한다.

@RestController
@RequestMapping("/rest2")
public class TestController2 {
	
	// 모든 경로에 /rest2/test1, /rest2/test2, /rest2/test3과 같이 붙이는 건
	// 번거로운 일이므로 상단에 @RequestMapping을 통해 /rest2를 지정해주면 좀 더 편리하다.
	
	// http://localhost:8080/mvc/rest2/test1 
	@GetMapping("/test1")
	public String test1() {
		return "hi rest";
	}

	// http://localhost:8080/mvc/rest2/test2
	@GetMapping("/test2")
	public String test2() {
		return "hi rest";
	}

	
	// test3, test4, test5는
	// jackson-databind dependency를 추가해야 반환 가능
	
	// http://localhost:8080/mvc/rest2/test3
	@GetMapping("/test3")
	public Map<String, String> test3() {
		// 키 벨류 형태를 가지고 있는 맵을 반환
		Map<String, String> data = new HashMap<String, String>();

		data.put("id", "ssafy");
		data.put("password", "1234");
		data.put("name", "양띵균");

		return data;
	}

	// http://localhost:8080/mvc/rest2/test4
	@GetMapping("/test4")
	public User test4() {
		User user = new User("ssafy", "1234", "양띵균");
		return user;
	}

	// http://localhost:8080/mvc/rest2/test5
	@GetMapping("/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy", "1234", "양띵균"));
		list.add(new User("hyunsoo", "3141592", "조현수"));
		list.add(new User("s4253541", "secret", "조용환"));
		list.add(new User("enugg", "1234", "김은지"));
		list.add(new User("dawon", "1008", "차다운"));

		return list;
	}

}
