package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;
	
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getList() {
		System.out.println("모든 게시글을 조회합니다.");
		return boardDao.selectAll();
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글을 작성합니다.");
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoard(int id) {
		System.out.println(id+"번 글을 읽었습니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	//서6 최영진 훌륭 그자체
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		System.out.println(id+"번 글을 삭제 하였습니다.");
		boardDao.deleteBoard(id);
	}

}
