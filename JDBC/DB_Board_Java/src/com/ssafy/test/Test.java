package com.ssafy.test;

import java.sql.SQLException;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
		// SELECT 테스트
		System.out.println(dao.selectOne(13)); // id 번호
		
		// UPDATE 테스트(조회수 증가)
//		try {
//			dao.updateViewCnt(7);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		// INSERT 테스트
		// 실제 데이터베이스에도 데이터가 등록되었음을 확인 가능
//		for(int i = 0; i<10; i++) {
//			Board board = new Board("제목"+i,"작성자"+i,"내용"+i);
//			dao.insertBoard(board);
//		}
		
		// DELETE 테스트
//		dao.deleteBoard(2); // id 번호

		
		// 콘솔에서 기능 테스트 동작하는지 확인
//		for(Board b : dao.selectAll()) {
//			System.out.println(b);
//		}
	}
}
