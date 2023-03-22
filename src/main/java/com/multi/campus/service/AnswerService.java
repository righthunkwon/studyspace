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
	// ��ȸ�� ����
	public int hitCount(int no);
	// �ۼ���
	public AnswerDTO answerSelect(int no);
	// ������ ref, lvl, step ����
	public AnswerDTO replyDataSelect(int no);
	// ������ ref�� ���� step�� ������ ������ Ŭ ��� step�� 1����
	public int stepUp(AnswerDTO orgDataDTO);
	// ��� ���
	public int replyWrite(AnswerDTO dto);
}
