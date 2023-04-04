package com.multi.campus.dao;

import java.util.List;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;

public interface RegisterDAO {
	// 추상메소드
	// 로그인 확인
	public RegisterDTO loginOk(String userid, String userpwd);
	// 아이디중복검사 (아이디의 갯수를 구하여 확인)
	public int idCheckCount(String userid);
	// 도로명 검색
	public List<ZipcodeDTO> zipSearch(String doroname);
	// 회원가입
	public int registerInsert(RegisterDTO dto);
	// 회원정보수정 폼
	public RegisterDTO registerEdit(String userid);
	// 회원정보수정 DB업데이트
	public int registerEditOk(RegisterDTO dto);
	// 이름과 이메일로 아이디 검색
	public String idSearch(String username, String email);
}
