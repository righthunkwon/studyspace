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
		// transaction ó���� ���� ��ü ����
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(def);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		
		try {
			BoardDTO dto1 = new BoardDTO();
			dto1.setSubject("Ʈ����� �׽�Ʈ1");
			dto1.setContent("�۳���1");
			dto1.setUserid((String)session.getAttribute("logId"));
			dto1.setIp("123.123.123.123");
			
			BoardDTO dto2 = new BoardDTO();
			dto2.setSubject("Ʈ����� �׽�Ʈ2");
			dto2.setContent("�۳���2");
			dto2.setUserid((String)session.getAttribute("logId"));
			dto2.setIp("123.123.123.123");
			
			// ���ڵ� ����
			service.transBoardInsert(dto1);
			service.transBoardInsert(dto2);
			
			// ���ڵ� ���
			transactionManager.commit(status);
			
		} catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return mav;
	}
}