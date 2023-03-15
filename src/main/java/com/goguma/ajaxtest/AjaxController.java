package com.goguma.ajaxtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController { 
	
	@RequestMapping("/ajaxStart")
	public String ajaxStart() { // String : 뷰
		return "ajax/ajaxView";
	}
	
	// ajaxString
	@RequestMapping(value="/ajaxString", method=RequestMethod.GET, produces="application/text;charset=UTF-8")
	@ResponseBody // 메서드가 반환하는 값을 HTTP 응답 바디에 직접 쓴다.
	public String ajaxString(int num, String name) { // String : 데이터  
		System.out.println("번호="+num);
		System.out.println("이름="+name);
		return "num=" + num + ", name=" + name;
	}
	
	// ajaxObject
	@GetMapping("/ajaxObject")
	@ResponseBody
	public TestDTO ajaxObject(int no, String subject, String content) {
		System.out.println("번호="+no);
		System.out.println("제목="+subject);
		System.out.println("내용="+content);
		
		TestDTO dto = new TestDTO();
		dto.setNo(no);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setUsername("임의의 사용자");
		
		System.out.println(dto.toString());
		
		return dto;
	}
	
	@PostMapping("/ajaxList")
	@ResponseBody
	public List<TestDTO> ajaxList(int no, String name) {
		System.out.println("번호="+no);
		System.out.println("이름="+name);
		
		List<TestDTO> list = new ArrayList<TestDTO>();
		list.add(new TestDTO(100, "ajaxList Test1", "Test...1", "권정훈"));
		list.add(new TestDTO(101, "ajaxList Test2", "Test...2", "권정훈"));
		list.add(new TestDTO(102, "ajaxList Test3", "Test...3", "권정훈"));
		list.add(new TestDTO(103, "ajaxList Test4", "Test...4", "권정훈"));
		list.add(new TestDTO(104, "ajaxList Test5", "Test...5", "권정훈"));
		
		return list;
	}
	
	@GetMapping("/ajaxMap")
	@ResponseBody
	public Map ajaxMap(int num, String name, String tel) {
		System.out.println("번호="+num);
		System.out.println("이름="+name);
		System.out.println("연락처="+tel);
		
		HashMap map = new HashMap();
		// String
		map.put("addr", "서울시 강남구 언주로");
		// int
		map.put("totalRecord", 10000); // autoboxing으로 인해 자동으로 Integer로 변환
		// DTO
		map.put("board", new TestDTO(1000, "java", "java ajax", "권정훈"));
		// List
		List<TestDTO> list = new ArrayList<TestDTO>();
		
		list.add(new TestDTO(105, "ajaxList Test(2)1", "Test(2)...1", "권정훈"));
		list.add(new TestDTO(106, "ajaxList Test(2)2", "Test(2)...2", "권정훈"));
		list.add(new TestDTO(107, "ajaxList Test(2)3", "Test(2)...3", "권정훈"));
		list.add(new TestDTO(108, "ajaxList Test(2)4", "Test(2)...4", "권정훈"));
		list.add(new TestDTO(109, "ajaxList Test(2)5", "Test(2)...5", "권정훈"));
		map.put("boardList", list);
		
		return map;
	}
	@RequestMapping(value="/ajaxJson", method=RequestMethod.GET, produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		/*
			프론트 단 : {no:1, username:"홍길동", tel:"010-1111-1111", addr:"서울특별시"}
			백 단 : {"no":"1", "username":"홍길동", "tel":"010-1111-1111", "addr":"서울특별시"}
		*/
		int no = 1;
		String username = "이순신";
		String tel = "010-7777-7777";
		String addr = "서울시 강남구 도곡로";
				
		String jsonTxt = "{\"no\":\""+no+"\",\"username\":\""+username+"\",\"tel\":\""+tel+"\",\"addr\":\""+addr+"\"}";
		System.out.println(jsonTxt);
		return jsonTxt;
	}
}
