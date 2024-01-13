package com.ssafy.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

// BoardDao의 구현 클래스
public class BoardDaoImpl implements BoardDao {

	// 싱글턴 패턴으로 구현
	private static BoardDao dao = new BoardDaoImpl();
	private List<Board> list = new ArrayList<>(); // DB 대신에 list 활용

	private BoardDaoImpl() {
		list.add(new Board("오늘 너무 어렵다.", "이민지", "따라치기 포기야..."));
		list.add(new Board("오늘 좀 빠른데?.", "조용환", "자체 0.8 배속으로 간다."));
		list.add(new Board("밥 먹고 싶다...", "김태윤", "점메추 제발요."));
	}

	public static BoardDao getInstance() {
		return dao;
	}

	@Override
	public void insertBoard(Board board) {
		list.add(board);
	}

	@Override
	public Board selectOne(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id)
				return list.get(i);
		}
		return null;
	}

	@Override
	public List<Board> selectAll() {
		return list;
	}

	@Override
	public void updateBoard(Board board) {
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			if (b.getId() == board.getId()) {
				b.setTitle(board.getTitle());
				b.setContent(board.getContent());
				return;
			}
		}
	}

	@Override
	public void deleteBoard(int id) {
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			if (b.getId() == id) {
				list.remove(i);
				return;
			}
		}
	}

	@Override
	public void updateViewCnt(int id) {
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			if (b.getId() == id) {
				int viewCnt = b.getViewCnt();
				b.setViewCnt(viewCnt + 1);
				break;
			}
		}
	}

}
