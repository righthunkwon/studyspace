package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.BoardDTO;
import com.multi.campus.dto.PagingVO;

public interface BoardService {
	// 글등록
	public int boardInsert(BoardDTO dto);
	// 총 레코드 수
	public int totalRecord();
	// 해당 페이지 선택
	public List<BoardDTO> pageSelect(PagingVO vo);
}
