package com.campus.home.board;

import java.util.ArrayList;
import java.util.List;

import com.campus.home.DBConnection;

public class BoardDAO extends DBConnection {
	// 게시판 레코드 전체를 선택한 뒤, 이를 컬렉션에 담아서 리턴
	public List<BoardDTO> boardAllSelect() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			// (1) DB연결
			getConnection();
			sql = "select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate "
					+ "from board order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt(1));
				dto.setSubject(rs.getString(2));
				dto.setUserid(rs.getString(3));
				dto.setHit(rs.getInt(4));
				dto.setWritedate(rs.getString(5));
				
				list.add(dto); // 리스트에 dto를 담는다.
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	// no에 해당하는 레코드를 선택한 뒤 dto를 담아 리턴
	public BoardDTO oneBoardSelect(int no) {
		BoardDTO dto = new BoardDTO();
		try {
			getConnection();
			sql = "select no, subject, userid, content, hit, writedate from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 선택된 레코드가 있을 때(글이 존재할 때)
				dto.setNo(rs.getInt(1));
				dto.setSubject(rs.getString(2));
				dto.setUserid(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getInt(5));
				dto.setWritedate(rs.getString(6));
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
	}
	
	// 조회수 증가
	public void hitCount(int no) {
		try {
			getConnection();
			sql = "update board set hit = hit+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 글 등록
	public int boardInsert(BoardDTO dto) {
		int result = 0;
		try {
			getConnection();
			sql = "insert into board(no, subject, content, userid, ip) values(board_sq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getUserid());
			pstmt.setString(4, dto.getIp());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();		
		}
		return result;
	}
	
	// 글 수정
	public int boardUpdate(BoardDTO dto) {
		int result = 0;
		try {
			getConnection();
			sql = "update board set subject=?, content=? where no=? and userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			pstmt.setString(4, dto.getUserid());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	// 글 삭제
	public int boardDelete(int no, String userid) {
		int result = 0;
		try {
			getConnection();
			sql = "delete from board where no=? and userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
}
