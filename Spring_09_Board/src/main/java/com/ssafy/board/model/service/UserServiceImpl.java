package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service // 서비스를 스프링 빈으로 등록
public class UserServiceImpl implements UserService {

	// @Autowired
	// 필드, 생성자, 설정자에 의존성 주입 가능
	
	@Autowired // 필드로 서비스에 DAO 의존성 주입(유저 서비스에 유저 DAO 의존성 주입)
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User login(User user) {
		// DB에 해당 ID를 넘겨서 데이터를 가지고 오고 
		// 가지고 온 유저 데이터와 내가 현재 가지고 있는 유저(u)의 비밀번호를 확인하고 일치하면 로그인
		User u = userDao.selectOne(user.getId());
		
		// 유저(u)가 존재하고 비밀번호가 일치할 경우에만 유저를 반환
		if(u != null && u.getPassword().equals(user.getPassword())) return u;
		
		// 유저(u)가 없거나 일치하지 않으면 null 반환
		return null;
	}

}
