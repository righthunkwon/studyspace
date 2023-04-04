package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.CommentDTO;

public interface CommentService {
	// ��� ���
	public int commentInsert(CommentDTO dto);
	// ��� ���
	public List<CommentDTO> commentListSelect(int no);
	// ��� ����(update���� ��ȯ���� int��)
	public int commentUpdate(CommentDTO dto); 
	// ��� ����(update���� ��ȯ���� int��)
	public int commentDelete(int c_no, String userid);
}
