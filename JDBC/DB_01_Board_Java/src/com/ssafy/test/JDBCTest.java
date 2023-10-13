package com.ssafy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;


// 1. JDBC 드라이버 로드(Class.forName)
// 2. 데이터베이스 연결(Connection)
// 3. SQL을 실행할 수 있게 하는 PreparedStatement 객체 생성
//    (혹은 Statement로도 구현 가능, PreparedStatement 권장)
// 3. SQL 준비 및 전송
// 4. 데이터베이스 연결 해제

public class JDBCTest {

	public JDBCTest() {
		// (1) 사용할 DBMS 드라이브 클래스 등록
		// Class라고 하는 클래스의 static 메소드 forName을 활용하여
		// MySQL 드라이버 클래스를 미리 등록
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		JDBCTest db = new JDBCTest();
		
		// 연동 확인
		for (Board b : db.selectAll()) {
			System.out.println(b);
		}
	}
	
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		
		// (2) 데이터베이스 연결
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "ssafy", "ssafy");
			
			// (3) SQL 준비 및 실행
			// Statement : SQL문을 수행하기 위한 객체
			// executeQuery		: SELECT 
			// executeUpdate	: INSERT, UPDATE, DELETE (*반환형은 변경된 rows를 나타내기 위해 int 사용)
			Statement stmt = conn.createStatement();
			
			// SQL문 작성
			String sql = "SELECT * FROM board";
			
			// SQL문 실행
			// ResultSet : SQL문에 대한 결과값을 담아 처리하는 객체
			ResultSet rs = stmt.executeQuery(sql);
			
			// SQL 결과를 담을 ResultSet에 데이터가 있는 동안에 반복하여 실행
			while (rs.next()) {
				Board board = new Board();
				
				// board에서 열을 가져올 때
				// 열의 이름을 적을 수도, 열의 번호를 적을 수도 있다.
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				
//				board.setId(rs.getInt(1));
//				board.setTitle(rs.getString(2));
//				board.setWriter(rs.getString(3));
//				board.setContent(rs.getString(4));
//				board.setViewCnt(rs.getInt(5));
//				board.setRegDate(rs.getString(6));
				
				list.add(board);
			}
			
			// (4) 데이터베이스 연결 해제
			// ResultSet - Statement(or PreparedStatement) - Connction 순으로 연결 종료
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
