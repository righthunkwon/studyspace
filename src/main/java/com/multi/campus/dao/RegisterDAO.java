package com.multi.campus.dao;

import java.util.List;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;

public interface RegisterDAO {
	// 로그인 확인
	public RegisterDTO loginOk(String userid, String userpwd);
	
	// 아이디중복검사 (아이디의 갯수를 구하여 확인)
	public int idCheckCount(String userid);
	
	// 도로명 검색
	public List<ZipcodeDTO> zipSearch(String doroname);
}
