package com.multi.campus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
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
	
	// �۳��뺸��
	@GetMapping("/answerView")
	public ModelAndView answerView(int no) {
		ModelAndView mav = new ModelAndView();

		// ��ȸ�� ����
		service.hitCount(no);
		// �ش� �� ����
		AnswerDTO dto = service.answerSelect(no);
		
		mav.addObject("dto", dto);
		mav.setViewName("answer/answerView");
		return mav; 
	}
	
	// ��۾��� ��
	@GetMapping("/answerReplyWrite/{no}")
	public ModelAndView answerReplyWrite(@PathVariable("no") int no) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("no", no);
		mav.setViewName("answer/answerReplyWrite");
		return mav;
	}
	
	// ��۾���(DB ���)
	@PostMapping("/answerReplyWriteOk")
	public ResponseEntity<String> answerReplyWriteOk(AnswerDTO dto, HttpServletRequest request) {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		// dto : ���۹�ȣ, ����, �۳���, (�߰� : ip, �۾���)
		dto.setIp(request.getRemoteAddr());
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		
		try {
			// ������ ref, lvl, step�� �����Ѵ�.
			AnswerDTO orgDataDTO = service.replyDataSelect(dto.getNo());
			
			// ���۰� ���� ref�� ���� ���� ������ step���� ũ�� 1�� ����
			int cnt = service.stepUp(orgDataDTO);
			System.out.println("cnt: "+cnt);
			
			// ��� ��� -> dto :����, �۳���, �ۼ���, ip (�߰�: orgDataDTO�� ref, lvl, step)
			dto.setRef(orgDataDTO.getRef());
			dto.setLvl(orgDataDTO.getLvl());
			dto.setStep(orgDataDTO.getStep());
			
			int result = service.replyWrite(dto);
			
			// ������ - ����Ʈ
			String tag = "<script>location.href='/campus/answer/answerList';</script>";
			entity = new ResponseEntity<String>(tag, headers, HttpStatus.OK);
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			
			// ���� �߻�
			String tag = "<script>";
			tag += "alert('�亯�� ��ϵ��� �ʾҽ��ϴ�.');";
			tag += "history.back();";
			tag += "</script>";
			
			entity = new ResponseEntity<String>(tag, headers, HttpStatus.BAD_REQUEST);
			transactionManager.rollback(status);
		}
		return entity;
	}
	// �������Խ��� �ۼ���(��)
	@GetMapping("/answerEdit/{no}")
	public ModelAndView answerEdit(@PathVariable("no") int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.getAnswerSelect(no));
		mav.setViewName("answer/answerEditForm");
		return mav;
	}
	
	// �������Խ��� �ۼ���(DB)
	@PostMapping("/answerEditOk")
	public ResponseEntity<String> answerEditOk(AnswerDTO dto, HttpSession session) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		dto.setUserid((String)session.getAttribute("logId"));
		try {
			int result = service.answerUpdate(dto);
			
			if(result > 0) { // ���� -> �� ���뺸��� �̵�
				String body = "<script>";
				body += "location.href='/campus/answer/answerView?no="+dto.getNo()+"';";
				body += "</script>";
				
				entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
			} else { // ���� �� ��
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// ���� �� ��(�����߻�)
			String body = "<script>";
			body += "alert('�� ������ �����߽��ϴ�.'";
			body += "history.back()";
			body += "</script>";
			
			entity = new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// �� ������ �����ϸ� �� �������, ������ �����ϸ� �� ���� ����� �̵�
	@GetMapping("/answerDelete")
	public ModelAndView answerDelete(int no, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// lvl�� ������ �������� �亯������ ����ó���Ѵ�.
		int lvl = service.getLevel(no);
		if(lvl==0) { // delete : ���� ref�� ���� ���� ����
			int result = service.answerDelete(no);
			System.out.println("������ ���ڵ� ��: "+result);
			if(result>0) { // ���� ����
				mav.setViewName("redirect:answerList");
			} else {
				mav.addObject("no", no);
				mav.setViewName("redirect:answerView");
			}
		} else { // update
			int result = service.answerDeleteUpdate(no);
			System.out.println("����(����)�� ���ڵ� ��: "+result);
			if(result>0) {
				mav.setViewName("redirect:answerList");
			} else {
				mav.addObject("no", no);
				mav.setViewName("redirect:answerView");
			}
		}
		return mav;
	}
}
