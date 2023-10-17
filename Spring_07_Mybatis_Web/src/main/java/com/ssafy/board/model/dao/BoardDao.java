package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

// DB 친화적으로 작성
// Mybatis는 mapper를 통해 BoardDaoImpl을 구현 
public interface BoardDao {
	// 게시글 전체 조회
	public List<Board> selectAll();

	// ID에 해당하는 게시글 하나 가져오기
	public Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);
}
