package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

// BoardService의 구현 클래스
public class BoardServiceImpl implements BoardService {

	// 싱글턴 패턴으로 구현
	private static BoardService service = new BoardServiceImpl();
	private BoardDao dao = BoardDaoImpl.getInstance(); // 의존성 주입(Autowired)
	private BoardServiceImpl() {
	}
	public static BoardService getInstance() {
		return service;
	}
	
	@Override
	public void writeBoard(Board board) {
		dao.insertBoard(board);
	}

	@Override
	public List<Board> getList() {
		return dao.selectAll();
	}

	@Override
	public Board getBoard(int id) {
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
