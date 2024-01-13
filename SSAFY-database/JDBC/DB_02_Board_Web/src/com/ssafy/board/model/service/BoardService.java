package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.Board;

//사용자 친화적으로 작성
public interface BoardService {
	// 게시글 전체 조회
	List<Board> getList();

	// 게시글 등록
	void writeBoard(Board board);

	// 게시글 상세 조회
	Board getBoard(int id) throws SQLException;

	// 게시글 수정
	void modifyBoard(Board board);

	// 게시글 삭제
	void removeBoard(int id);
}
