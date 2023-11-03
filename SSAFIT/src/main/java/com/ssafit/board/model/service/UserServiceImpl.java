package com.ssafit.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.UserDao;
import com.ssafit.board.model.dto.User;


@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// (1) 회원가입
	@Override
	public int signUp(User user) {
		return userDao.insertUser(user);
	}
	
	// (2) 로그인 
	public User logIn(String id, String password) {
		User u = userDao.selectOne(id);
		if(u != null && u.getPassword().equals(password)){
			return u;
		}
		return null;
	}
	
	// (3) 회원 탈퇴 
	@Override
	public int signOut(String id, String password) {
		User tmp = userDao.selectOne(id);
		if(tmp !=null && tmp.getPassword().equals(password)){
			return userDao.deleteUser(tmp.getUserId(), tmp.getPassword());
		}
		return 0;
	}
	
	// (4) 닉네임 수정
	public int updateUser(String id, String nickname) {
		return userDao.updateUser(id, nickname);
	}
	
}
