package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;

public interface RegisterService {
	// DAO에 있는 메소드와 동일한 메소드
	// 로그인 확인
	public RegisterDTO loginOk(String userid, String userpwd);
	// 아이디중복검사
	public int idCheckCount(String userid);
	// 우편번호검색
	public List<ZipcodeDTO> zipSearch(String doroname);
	// 회원가입
	public int registerInsert(RegisterDTO dto);
	// 회원정보수정
	public RegisterDTO registerEdit(String userid);
	// 회원정보수정 DB반영
	public int registerEditOk(RegisterDTO dto);
}
