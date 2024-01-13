package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

// 흐름
// Controller - Service - DAO - DB - DAO - Service - Controller - View(JSP)

// Service와 DAO는 모두 Model에 해당하는데, 
// Service는 Controller와 통신하고,
// DAO는 Database와 통신한다.
public interface BoardService {
	// 게시글 등록
	void writeBoard(Board board);
	
	// 게시글 전체 조회
	List<Board> getList();
	
	// 게시글 상세 조회
	Board getBoard(int id);
	
	// 게시글 수정
	void modifyBoard(Board board);
	
	// 게시글 삭제
	void removeBoard(int id);
}
