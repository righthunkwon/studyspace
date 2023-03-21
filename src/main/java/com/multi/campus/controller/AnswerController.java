package com.multi.campus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.AnswerDTO;
import com.multi.campus.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	AnswerService service;
	
	@GetMapping("/answerList")
	public ModelAndView answerList() {
		ModelAndView mav = new ModelAndView();
		
		// �� ���ڵ� ��
		int totalRecord = service.answerTotalRecord();
		// ���ڵ� ����
		List<AnswerDTO> list = service.answerAllSelect();
		
		mav.addObject("totalRecord", totalRecord);
		mav.addObject("list", list);
		
		mav.setViewName("answer/answerList");
		return mav;
	}
	
	// ���۾��� ��
	@GetMapping("/answerWrite")
	public ModelAndView answerWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("answer/answerWriteForm");
		return mav;
	}
	
	// ���۾��� DB
	@PostMapping("/answerWriteOk")
	public ResponseEntity<String> answerWriteOk(AnswerDTO dto, HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		// ip
		dto.setIp(request.getRemoteAddr()); 
		// �α��� id
		dto.setUserid((String)request.getSession().getAttribute("logId")); 
		
		try { 
			// �� ��� ���� : answerList�� ������.
			service.answerInsert(dto);
			String body = "<script> location.href='/campus/answer/answerList';</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
			
		} catch (Exception e) { 
			// �� ��� ���� : answerWrite�� ������.
			String body = "<script>";
			body += "alert('�� ��Ͽ� �����Ͽ����ϴ�.');";
			body += "history.back();";
			body += "</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
