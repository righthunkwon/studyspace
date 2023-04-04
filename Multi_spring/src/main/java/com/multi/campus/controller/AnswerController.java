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
		
		// 총 레코드 수
		int totalRecord = service.answerTotalRecord();
		// 레코드 선택
		List<AnswerDTO> list = service.answerAllSelect();
		
		mav.addObject("totalRecord", totalRecord);
		mav.addObject("list", list);
		
		mav.setViewName("answer/answerList");
		return mav;
	}
	
	// 원글쓰기 폼
	@GetMapping("/answerWrite")
	public ModelAndView answerWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("answer/answerWriteForm");
		return mav;
	}
	
	// 원글쓰기 DB
	@PostMapping("/answerWriteOk")
	public ResponseEntity<String> answerWriteOk(AnswerDTO dto, HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		// ip
		dto.setIp(request.getRemoteAddr()); 
		// 로그인 id
		dto.setUserid((String)request.getSession().getAttribute("logId")); 
		
		try { 
			// 글 등록 성공 : answerList로 보낸다.
			service.answerInsert(dto);
			String body = "<script> location.href='/campus/answer/answerList';</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
			
		} catch (Exception e) { 
			// 글 등록 실패 : answerWrite로 보낸다.
			String body = "<script>";
			body += "alert('글 등록에 실패하였습니다.');";
			body += "history.back();";
			body += "</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 글내용보기
	@GetMapping("/answerView")
	public ModelAndView answerView(int no) {
		ModelAndView mav = new ModelAndView();

		// 조회수 증가
		service.hitCount(no);
		// 해당 글 선택
		AnswerDTO dto = service.answerSelect(no);
		
		mav.addObject("dto", dto);
		mav.setViewName("answer/answerView");
		return mav; 
	}
	
	// 답글쓰기 폼
	@GetMapping("/answerReplyWrite/{no}")
	public ModelAndView answerReplyWrite(@PathVariable("no") int no) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("no", no);
		mav.setViewName("answer/answerReplyWrite");
		return mav;
	}
	
	// 답글쓰기(DB 등록)
	@PostMapping("/answerReplyWriteOk")
	public ResponseEntity<String> answerReplyWriteOk(AnswerDTO dto, HttpServletRequest request) {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		// dto : 원글번호, 제목, 글내용, (추가 : ip, 글쓴이)
		dto.setIp(request.getRemoteAddr());
		dto.setUserid((String)request.getSession().getAttribute("logId"));
		
		try {
			// 원글의 ref, lvl, step을 선택한다.
			AnswerDTO orgDataDTO = service.replyDataSelect(dto.getNo());
			
			// 원글과 같은 ref를 가진 글의 원글이 step보다 크면 1씩 증가
			int cnt = service.stepUp(orgDataDTO);
			System.out.println("cnt: "+cnt);
			
			// 답글 등록 -> dto :제목, 글내용, 작성자, ip (추가: orgDataDTO의 ref, lvl, step)
			dto.setRef(orgDataDTO.getRef());
			dto.setLvl(orgDataDTO.getLvl());
			dto.setStep(orgDataDTO.getStep());
			
			int result = service.replyWrite(dto);
			
			// 정상구현 - 리스트
			String tag = "<script>location.href='/campus/answer/answerList';</script>";
			entity = new ResponseEntity<String>(tag, headers, HttpStatus.OK);
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			
			// 예외 발생
			String tag = "<script>";
			tag += "alert('답변이 등록되지 않았습니다.');";
			tag += "history.back();";
			tag += "</script>";
			
			entity = new ResponseEntity<String>(tag, headers, HttpStatus.BAD_REQUEST);
			transactionManager.rollback(status);
		}
		return entity;
	}
	// 계층형게시판 글수정(폼)
	@GetMapping("/answerEdit/{no}")
	public ModelAndView answerEdit(@PathVariable("no") int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.getAnswerSelect(no));
		mav.setViewName("answer/answerEditForm");
		return mav;
	}
	
	// 계층형게시판 글수정(DB)
	@PostMapping("/answerEditOk")
	public ResponseEntity<String> answerEditOk(AnswerDTO dto, HttpSession session) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		dto.setUserid((String)session.getAttribute("logId"));
		try {
			int result = service.answerUpdate(dto);
			
			if(result > 0) { // 수정 -> 글 내용보기로 이동
				String body = "<script>";
				body += "location.href='/campus/answer/answerView?no="+dto.getNo()+"';";
				body += "</script>";
				
				entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
			} else { // 수정 안 됨
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 수정 안 됨(에러발생)
			String body = "<script>";
			body += "alert('글 수정에 실패했습니다.'";
			body += "history.back()";
			body += "</script>";
			
			entity = new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 글 삭제에 성공하면 글 목록으로, 삭제에 실패하면 글 내용 보기로 이동
	@GetMapping("/answerDelete")
	public ModelAndView answerDelete(int no, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// lvl을 가져와 원글인지 답변글인지 구별처리한다.
		int lvl = service.getLevel(no);
		if(lvl==0) { // delete : 같은 ref를 가진 글을 삭제
			int result = service.answerDelete(no);
			System.out.println("삭제된 레코드 수: "+result);
			if(result>0) { // 삭제 성공
				mav.setViewName("redirect:answerList");
			} else {
				mav.addObject("no", no);
				mav.setViewName("redirect:answerView");
			}
		} else { // update
			int result = service.answerDeleteUpdate(no);
			System.out.println("삭제(수정)된 레코드 수: "+result);
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
