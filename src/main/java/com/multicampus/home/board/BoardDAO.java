package com.multicampus.home.board;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.multicampus.home.DBConnection;

public class BoardDAO extends DBConnection{
	
	public int boardInsert(BoardDTO dto) {
		int result = 0;
		try {
			// 1. DB 연결
			getConnection();
			
			// 2. 쿼리문 -> statement 생성
			sql = "insert into board(no, subject, content, userid, ip) values(board_sq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getUserid());
			pstmt.setString(4, dto.getIp());
			
			// 3. 실행
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
		// 글 목록 선택
		public List<BoardDTO> boardAllRecord() {
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			
			try {
				getConnection();
				
				sql = "select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate from board order by no desc";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					
					dto.setNo(rs.getInt(1));
					dto.setSubject(rs.getString(2));
					dto.setUserid(rs.getString(3));
					dto.setHit(rs.getInt(4));
					dto.setWritedate(rs.getString(5));
					
					list.add(dto);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return list;
		}
		
		// 글 선택(글 내용 보기)
		public BoardDTO boardSelect(int no) {
			BoardDTO dto = new BoardDTO();
			try {
				// 조회수 증가
				hitCount(no);
				
				// 해당글(no에 저장)을 선택하여 DTO에 담고 dto를 리턴
				getConnection();
				
				sql = "select b.no, r.username, b.hit, b.writedate, b.subject, b.content, b.userid "
						+ "from board b join register r on b.userid =  r.userid and no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dto.setNo(rs.getInt(1));
					dto.setUsername(rs.getString(2));
					dto.setHit(rs.getInt(3));
					dto.setWritedate(rs.getString(4));
					dto.setSubject(rs.getString(5));
					dto.setContent(rs.getString(6));
					dto.setUserid(rs.getString(7));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return dto;
		}
		// 글 수정폼(해당 레코드의 no, subject, content를 선택하는 메소드)
		public BoardDTO boardEditSelect(int no) {
			BoardDTO dto = new BoardDTO();
			try {
				getConnection();
				sql = "select no, subject, content from board where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dto.setNo(rs.getInt(1));
					dto.setSubject(rs.getString(2));
					dto.setContent(rs.getString(3));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return dto;
		}
		
		// 글 수정(DB 업데이트)
		public int boardEditUpdate(BoardDTO dto) {
			int result = 0;
			try {
				getConnection();
				
				sql = "update board set subject=?, content=? where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getSubject());
				pstmt.setString(2, dto.getContent());
				pstmt.setInt(3, dto.getNo());
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return result;
		}
		// 글 삭제
		
		// 하단은 오류 방지용으로 그냥 채워둔 것 -> 수정 필요
		public int boardDelete(BoardDTO dto) {
			int result = 0;
			try {
				getConnection();
				
				sql = "update board set subject=?, content=? where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getSubject());
				pstmt.setString(2, dto.getContent());
				pstmt.setInt(3, dto.getNo());
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return result;
		}
		
		
		// 조회수 증가
		public void hitCount(int no) {
			BoardDTO dto = new BoardDTO();
			try {
				getConnection();
				
				sql = "update board set hit = hit + 1 where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
				

			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			
		}
}


