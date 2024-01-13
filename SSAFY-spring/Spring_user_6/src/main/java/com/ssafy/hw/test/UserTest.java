package com.ssafy.hw.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory  = context.getBean(SqlSessionFactory.class);
        SqlSession session = sqlSessionFactory.openSession(true);
		UserDao userDao = session.getMapper(UserDao.class);
		
		// 유저 삽입
//		User u = new User("kwon", "5678", "권싸피", "ssafy.kwon@ssafy.com", 28);
//		userDao.insert(u);
		
		// Id를 기준으로 유저 조회
//		System.out.println(userDao.searchById("kwon")); 
		
		// 이름을 기준으로 유저 조회
//		System.out.println(userDao.searchByName("김싸피"));
//		System.out.println(userDao.searchByName("싸피")); // %#{name}%을 기준으로 조회하므로 싸피가 포함된 유저를 전부 조회
//		System.out.println(userDao.searchByName("테스트")); 
		
		// 전체 데이터 조회
		for (User user : userDao.selectAll()) {
			System.out.println(user);
		}
	}
}
