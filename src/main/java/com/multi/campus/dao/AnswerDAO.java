package com.multi.campus.dao;

import java.util.List;

import com.multi.campus.dto.AnswerDTO;

public interface AnswerDAO {
	// �� ���ڵ� ��
	public int answerTotalRecord();
	// ���ڵ� ��ü ����
	public List<AnswerDTO> answerAllSelect();
	// �۵��
	public int answerInsert(AnswerDTO dto);
}
