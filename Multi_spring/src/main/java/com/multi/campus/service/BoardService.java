package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.BoardDTO;
import com.multi.campus.dto.PagingVO;

public interface BoardService {
	// �۵��
	public int boardInsert(BoardDTO dto);
	// �� ���ڵ� ��
	public int totalRecord(PagingVO vo);
	// �ش� ������ ����
	public List<BoardDTO> pageSelect(PagingVO vo);
	// �ۼ���(no)
	public BoardDTO boardSelect(int no);
	// �ۼ���(���� ��)
	public BoardDTO boardEditSelect(int no);
	// �ۼ���(DB) : update���� int�� ��ȯ��
	public int boardUpdate(BoardDTO dto);
	// ��ȸ�� ����
	public void boardHitCount(int no);
	// �ۻ���
	public int boardDelete(BoardDTO dto);
	// ���� �� �� ���� ����
	public int boardMultiLineDelete(List<Integer> noList);
}
