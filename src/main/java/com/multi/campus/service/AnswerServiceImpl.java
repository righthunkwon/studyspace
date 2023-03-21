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
}
