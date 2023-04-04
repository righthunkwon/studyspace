package com.multi.campus.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.multi.campus.dto.AnswerDTO;

public interface AnswerDAO {
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
	// �������Խ��� �ۼ���(��)
	public AnswerDTO getAnswerSelect(int no);
	// �������Խ��� �ۼ���(DB)
	public int answerUpdate(AnswerDTO dto);
	// lvl ��������(���� �� �ʿ�)
	public int getLevel(int no);
	// �����ϱ� - delete
	public int answerDelete(int no);
	// �����ϱ� - update
	public int answerDeleteUpdate(int no);
}
