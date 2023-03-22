package com.multi.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campus.dao.AnswerDAO;
import com.multi.campus.dto.AnswerDTO;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerDAO dao;

	@Override
	public int answerTotalRecord() {
		return dao.answerTotalRecord();
	}

	@Override
	public List<AnswerDTO> answerAllSelect() {
		return dao.answerAllSelect();
	}

	@Override
	public int answerInsert(AnswerDTO dto) {
		return dao.answerInsert(dto);
	}

	@Override
	public int hitCount(int no) {
		return dao.hitCount(no);
	}

	@Override
	public AnswerDTO answerSelect(int no) {
		return dao.answerSelect(no);
	}

	@Override
	public AnswerDTO replyDataSelect(int no) {
		return dao.replyDataSelect(no);
	}

	@Override
	public int stepUp(AnswerDTO orgDataDTO) {
		return dao.stepUp(orgDataDTO);
	}

	@Override
	public int replyWrite(AnswerDTO dto) {
		return dao.replyWrite(dto);
	}
	
	
}
