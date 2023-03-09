package com.multi.campus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.multi.campus.dao.BoardDAO;
import com.multi.campus.dto.BoardDTO;
import com.multi.campus.dto.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO dao;

	@Override
	public int boardInsert(BoardDTO dto) {
		return dao.boardInsert(dto);
	}

	@Override
	public int totalRecord(PagingVO vo) {
		return dao.totalRecord(vo);
	}

	@Override
	public List<BoardDTO> pageSelect(PagingVO vo) {
		return dao.pageSelect(vo);
	}

	@Override
	public BoardDTO boardSelect(int no) {
		return dao.boardSelect(no);
	}

	@Override
	public BoardDTO boardEditSelect(int no) {
		return dao.boardEditSelect(no);
	}

	@Override
	public int boardUpdate(BoardDTO dto) {
		return dao.boardUpdate(dto);
	}

	@Override
	public void boardHitCount(int no) {
		dao.boardHitCount(no);
	}

	@Override
	public int boardDelete(BoardDTO dto) {
		return dao.boardDelete(dto);
	}
}
