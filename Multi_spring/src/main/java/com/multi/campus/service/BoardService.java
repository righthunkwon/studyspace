package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.BoardDTO;
import com.multi.campus.dto.PagingVO;

public interface BoardService {
	// 글등록
	public int boardInsert(BoardDTO dto);
	// 총 레코드 수
	public int totalRecord(PagingVO vo);
	// 해당 페이지 선택
	public List<BoardDTO> pageSelect(PagingVO vo);
	// 글선택(no)
	public BoardDTO boardSelect(int no);
	// 글선택(수정 시)
	public BoardDTO boardEditSelect(int no);
	// 글수정(DB) : update문은 int가 반환형
	public int boardUpdate(BoardDTO dto);
	// 조회수 증가
	public void boardHitCount(int no);
	// 글삭제
	public int boardDelete(BoardDTO dto);
	// 여러 글 한 번에 삭제
	public int boardMultiLineDelete(List<Integer> noList);
}
