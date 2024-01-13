package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

// 이전에는 BoardDao 인터페이스의 구현 클래스인 BoardDaoImpl에
// 각 메소드들의 구체적인 구현 코드를 작성하여 기능을 구현하였지만,  
// MyBatis에서는 boaraMapper.xml에 Dao 인터페이스를 구현한다.
public interface BoardDao {
	// 전체 게시글 조회
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
