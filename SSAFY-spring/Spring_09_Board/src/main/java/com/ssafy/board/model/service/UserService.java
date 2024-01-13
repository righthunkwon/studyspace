package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {

	// 인터페이스에는 public abstract 키워드가 생략 
	List<User> getUserList();

	void signup(User user);

	User login(User user);
	
}