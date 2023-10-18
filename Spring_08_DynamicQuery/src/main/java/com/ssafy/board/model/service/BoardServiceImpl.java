package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;
	
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getList() {
		System.out.println("모든 게시글을 가지고 왔습니다.");
		return boardDao.selectAll();
	}

	// 트랜잭션
	// 한 번에 수행되어야 할 일련의 작업의 단위
	// 트랜잭션은 CRUD중 CUD에 적용하는 것이 자연스럽다.
	// 즉, SELECT 이외에 INSERT, UPDATE, DELETE에는 @Transactional 어노테이션을 붙여주는 것이 좋다. 
	
	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글을 작성합니다.");
		boardDao.insertBoard(board);
	}
	
//	@Transactional
//	@Override
//	public void writeBoard(Board board) {
//		System.out.println("게시글을 작성합니다.");
//	
//		// id를 99번으로 결정한 후 INSERT
//		board.setId(99);
//	
//		// 첫글은 삽입이 잘 되지만(id=99가 없을 경우)
//		// 두번째 글에서는 오류가 발생하여 트랜잭션 작업 단위에 있는 전체 작업이 ROLLBACK이 이루어진다.
//		boardDao.insertBoard(board); 
//		boardDao.insertBoard(board); 
//	}
	
	@Override
	public Board getBoard(int id) {
		System.out.println(id+"번 글을 읽었습니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println(id+"번 글을 삭제 했습니다.");
		boardDao.deleteBoard(id);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

}
