package com.ssafit.board.model.service;

import com.ssafit.board.model.dto.User;

public interface UserService {
	
	// (1) 회원가입
	public int signUp(User user);
	
	// (2) 로그인
	public User logIn(String id, String password);
	
	// (3) 회원탈퇴
	public int signOut(String id , String password);
	
	// (4) 닉네임 변경
	public int updateUser(String id, String nickname);
	
}
