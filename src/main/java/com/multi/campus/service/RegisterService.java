package com.multi.campus.service;

import com.multi.campus.dto.RegisterDTO;

public interface RegisterService {
	// DAO에 있는 메소드와 동일한 메소드
	public RegisterDTO loginOk(String userid, String userpwd);
}
