package com.ssafy.board.test;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);

		// (1) SELECT
//		System.out.println(dao.selectOne(11));

		// (2) INSERT
//		Board b = new Board("XML 활용","권정훈", "EZ");
//		dao.insertBoard(b);

		// (3) DELETE
//		dao.deleteBoard(13);

		// (4) UPDATE(조회수)
//		dao.updateViewCnt(14);

		// (4) UPDATE(데이터 수정)
//		Board b = dao.selectOne(3);
//		b.setTitle("대답 잘 하는 법(수정본)");
//		b.setContent("채팅 잘 치면 됨(수정본)");
//		dao.updateBoard(b);
		
		// (0) 전체 데이터 출력 확인
		for (Board board : dao.selectAll()) {
			System.out.println(board);
		}

	}
}
