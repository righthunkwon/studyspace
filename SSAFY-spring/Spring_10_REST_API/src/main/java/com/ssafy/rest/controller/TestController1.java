package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.rest.model.dto.User;

@Controller
public class TestController1 {

	// REST(Representational State Transfer)
	// REST란 HTTP URI를 통해 자원(Resource)을 명시하고,
	// HTTP Method(POST,GET,PUT/PATCH,DELETE)를 통해
	// 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.
	// POST는 CREATE에, GET은 READ에, PUT/PATCH는 UPDATE에, DELETE는 DELETE에 해당한다.
	
	// http://localhost:8080/mvc/rest1/test1
	// 404에러 발생(Page Not Found) - 뷰리졸버 입장에서는 반환된 문자열을 데이터가 뷰를 찾으려고 하여 페이지를 찾을 수 없다는 오류 발생 
	@GetMapping("/rest1/test1")
	public String test1() {
		return "hi rest"; // REST 방식은 페이지가 아니라 데이터를 반환하는데 현재는 별도의 명시가 없어서 뷰 리졸버가 반환값을 페이지로 판단 
	}
	
	// http://localhost:8080/mvc/rest1/test2
	// @ResponseBody 어노테이션을 통해 반환되는 것이 페이지(뷰, jsp)가 아니라 데이터임을 명시
	// @(어노테이션)의 순서는 관계가 없다.
	@ResponseBody
	@GetMapping("/rest1/test2")
	public String test2() {
		return "hi rest"; // 데이터 반환
	}
	
	// http://localhost:8080/mvc/rest1/test3
	@ResponseBody
	@GetMapping("/rest1/test3")
	public Map<String, String> test3() {
		// 키 벨류 형태를 가지고 있는 맵을 반환
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("id", "ssafy");
		data.put("password", "1234");
		data.put("name", "권정훈");
		
		return data; // map을 별도의 설정 없이 반환할 수는 없음 
		// jackson-databind라는 dependency를 추가하여 map을 json으로 변환하여 반환
	}

	// http://localhost:8080/mvc/rest1/test4
	// jackson-databind는 DTO 객체 역시 JSON으로 자동으로 변환하여 반환 가능하게 만들어준다.
	@ResponseBody
	@GetMapping("/rest1/test4")
	public User test4() {
		User user = new User("ssafy", "5678", "권정훈");
		return user; // 유저라는 객체도 jackson-databind를 통해 데이터로서 반환
	}
	
	// http://localhost:8080/mvc/rest1/test5
	// jackson-databind는 list 역시 JSON으로 자동으로 변환하여 반환 가능하게 만들어준다.
	@ResponseBody
	@GetMapping("/rest1/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy1", "1234", "권정훈"));
		list.add(new User("ssafy2", "1234", "조현수"));
		list.add(new User("ssafy3", "1234", "조용환"));
		list.add(new User("ssafy4", "1234", "김은지"));
		list.add(new User("ssafy5", "1234", "차다운"));
		
		return list; // list 역시 jackson-databind를 통해 데이터로서 반환
	}
	
}
