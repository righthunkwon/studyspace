package com.multi.campus.dao;

import com.multi.campus.dto.RegisterDTO;

public interface RegisterDAO {
	// 추상메소드
	public RegisterDTO loginOk(String userid, String userpwd);
}
