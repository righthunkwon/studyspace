package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return this.userDao;
	}

	@Override
	@Transactional // 무결성을 위한 애노테이션
	public int insert(User user) {
		/*
		 * 사용자 정보를 등록한다. userDao.insert(user); 
		 * 고의로 예외를 발생시키는 코드를 삽입한다. 
		 * 트랜잭션 처리가 되면 에외 발생시 롤백된다. 
		 * 트랜잭션 처리가 되지 않으면 그대로 DB에 반영된다. int err = 1/0;
		 */
		
		// user.setId("kwon"); // 이미 존재하는 아이디
		return userDao.insert(user); // 이미 존재하는 kwon을 삽입하려고 하여 ROLLBACK
	}

	@Override
	public User searchById(String id) {
		return userDao.searchById(id);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> searchByName(String name) {
		return userDao.searchByName(name);
	}

	@Override
	public List<User> searchByCondition(SearchCondition con) {
		return userDao.searchByCondition(con);
	}

}
