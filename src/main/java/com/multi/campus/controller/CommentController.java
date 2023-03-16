package com.multi.campus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
}
