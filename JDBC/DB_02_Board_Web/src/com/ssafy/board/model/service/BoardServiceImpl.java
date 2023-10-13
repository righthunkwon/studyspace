package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class BoardServiceImpl implements BoardService {

	//의존성 주입
	private BoardDao dao = BoardDaoImpl.getInstance();
	//서비스 싱글턴으로 만들기
	private static BoardService service = new BoardServiceImpl();
	private BoardServiceImpl() {
	}
	public static BoardService getInstance() {
		return service;
	}
	
	
	@Override
	public List<Board> getList() {
		return dao.selectAll();
	}

	@Override
	public void writeBoard(Board board) {
		dao.insertBoard(board);
	}

	@Override
	public Board getBoard(int id) throws SQLException {
		dao.updateViewCnt(id);
		return dao.selectOne(id);
	}

	@Override
	public void modifyBoard(Board board) {
		dao.updateBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		dao.deleteBoard(id);
	}

}
