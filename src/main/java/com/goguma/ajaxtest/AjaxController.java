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
	public String ajaxStart() { // String : ��
		return "ajax/ajaxView";
	}
	
	// ajaxString
	@RequestMapping(value="/ajaxString", method=RequestMethod.GET, produces="application/text;charset=UTF-8")
	@ResponseBody // �޼��尡 ��ȯ�ϴ� ���� HTTP ���� �ٵ� ���� ����.
	public String ajaxString(int num, String name) { // String : ������  
		System.out.println("��ȣ="+num);
		System.out.println("�̸�="+name);
		return "num=" + num + ", name=" + name;
	}
	
	// ajaxObject
	@GetMapping("/ajaxObject")
	@ResponseBody
	public TestDTO ajaxObject(int no, String subject, String content) {
		System.out.println("��ȣ="+no);
		System.out.println("����="+subject);
		System.out.println("����="+content);
		
		TestDTO dto = new TestDTO();
		dto.setNo(no);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setUsername("������ �����");
		
		System.out.println(dto.toString());
		
		return dto;
	}
	
	@PostMapping("/ajaxList")
	@ResponseBody
	public List<TestDTO> ajaxList(int no, String name) {
		System.out.println("��ȣ="+no);
		System.out.println("�̸�="+name);
		
		List<TestDTO> list = new ArrayList<TestDTO>();
		list.add(new TestDTO(100, "ajaxList Test1", "Test...1", "������"));
		list.add(new TestDTO(101, "ajaxList Test2", "Test...2", "������"));
		list.add(new TestDTO(102, "ajaxList Test3", "Test...3", "������"));
		list.add(new TestDTO(103, "ajaxList Test4", "Test...4", "������"));
		list.add(new TestDTO(104, "ajaxList Test5", "Test...5", "������"));
		
		return list;
	}
	
	@GetMapping("/ajaxMap")
	@ResponseBody
	public Map ajaxMap(int num, String name, String tel) {
		System.out.println("��ȣ="+num);
		System.out.println("�̸�="+name);
		System.out.println("����ó="+tel);
		
		HashMap map = new HashMap();
		// String
		map.put("addr", "����� ������ ���ַ�");
		// int
		map.put("totalRecord", 10000); // autoboxing���� ���� �ڵ����� Integer�� ��ȯ
		// DTO
		map.put("board", new TestDTO(1000, "java", "java ajax", "������"));
		// List
		List<TestDTO> list = new ArrayList<TestDTO>();
		
		list.add(new TestDTO(105, "ajaxList Test(2)1", "Test(2)...1", "������"));
		list.add(new TestDTO(106, "ajaxList Test(2)2", "Test(2)...2", "������"));
		list.add(new TestDTO(107, "ajaxList Test(2)3", "Test(2)...3", "������"));
		list.add(new TestDTO(108, "ajaxList Test(2)4", "Test(2)...4", "������"));
		list.add(new TestDTO(109, "ajaxList Test(2)5", "Test(2)...5", "������"));
		map.put("boardList", list);
		
		return map;
	}
	@RequestMapping(value="/ajaxJson", method=RequestMethod.GET, produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		/*
			����Ʈ �� : {no:1, username:"ȫ�浿", tel:"010-1111-1111", addr:"����Ư����"}
			�� �� : {"no":"1", "username":"ȫ�浿", "tel":"010-1111-1111", "addr":"����Ư����"}
		*/
		int no = 1;
		String username = "�̼���";
		String tel = "010-7777-7777";
		String addr = "����� ������ �����";
				
		String jsonTxt = "{\"no\":\""+no+"\",\"username\":\""+username+"\",\"tel\":\""+tel+"\",\"addr\":\""+addr+"\"}";
		System.out.println(jsonTxt);
		return jsonTxt;
	}
}
