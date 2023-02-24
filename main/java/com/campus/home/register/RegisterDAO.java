package com.campus.home.register;

import java.sql.ResultSet;

import com.campus.home.DBConnection;

public class RegisterDAO extends DBConnection{
	// 로그인
	public RegisterDTO login(RegisterDTO dto) {
		RegisterDTO dtoResult = new RegisterDTO();
		try {
			getConnection();
			sql = "select userid, username from register where userid=? and userpwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dtoResult.setUserid(rs.getString(1));
				dtoResult.setUsername(rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dtoResult;
	}
	
}
