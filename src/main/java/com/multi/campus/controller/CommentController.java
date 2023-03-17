package com.multi.campus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.campus.dto.CommentDTO;
import com.multi.campus.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	CommentService service;
	@PostMapping("/commentSend")
	public String commentSend(CommentDTO dto, HttpServletRequest request) {
		dto.setIp(request.getRemoteAddr()); // ip
		dto.setUserid((String)request.getSession().getAttribute("logId")); // userid
		int result = service.commentInsert(dto);
		return result+"";
	}
	
	// ��۸��
	@GetMapping("/commentList")
	public List<CommentDTO> commentList(int no) { // no : ���� �� ��ȣ
		return service.commentListSelect(no);
	}
	
	// ��ۼ���
	@PostMapping("/commentEdit")
	public String commentEdit(CommentDTO dto, HttpSession session) {
		dto.setUserid((String)session.getAttribute("logId"));
		int result = service.commentUpdate(dto);
		return String.valueOf(result);
	}
	
	// ��ۻ���
	@GetMapping("/commentDelete")
	public String commentDelete(int c_no, HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		return String.valueOf(service.commentDelete(c_no, userid));
	}
}
