package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.AnswerDTO;

public interface AnswerService {
	// �� ���ڵ� ��
	public int answerTotalRecord();
	// ���ڵ� ��ü ����
	public List<AnswerDTO> answerAllSelect();
	// �۵��
	public int answerInsert(AnswerDTO dto);
}
