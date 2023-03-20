package com.multi.campus;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.BoardDTO;
import com.multi.campus.service.TransactionService;

@Controller
public class TranscationController {
	@Autowired
	TransactionService service;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@GetMapping("/transaction")
	public ModelAndView transactionTest(HttpSession session) {
		// transaction 처리를 위한 객체 생성
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(def);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		
		try {
			BoardDTO dto1 = new BoardDTO();
			dto1.setSubject("트랜잭션 테스트1");
			dto1.setContent("글내용1");
			dto1.setUserid((String)session.getAttribute("logId"));
			dto1.setIp("123.123.123.123");
			
			BoardDTO dto2 = new BoardDTO();
			dto2.setSubject("트랜잭션 테스트2");
			dto2.setContent("글내용2");
			dto2.setUserid((String)session.getAttribute("logId"));
			dto2.setIp("123.123.123.123");
			
			// 레코드 삽입
			service.transBoardInsert(dto1);
			service.transBoardInsert(dto2);
			
			// 레코드 등록
			transactionManager.commit(status);
			
		} catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return mav;
	}
}