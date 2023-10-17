package com.ssafy.ws.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dao.UserDao;

public class MovieTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory  = context.getBean(SqlSessionFactory.class);
        SqlSession session = sqlSessionFactory.openSession(true);
        MovieDao movieDao = session.getMapper(MovieDao.class);
		UserDao userDao = session.getMapper(UserDao.class);
		
		
		// 영화 테스트
		// 영화 등록
//		Movie m = new Movie(100, "등록확인용", "등록확인용", "등록확인용", 100);
//		movieDao.insert(m);

		// 영화 아이디로 영화 조회
//		System.out.println(movieDao.searchById(100)); 
		
		// 영화 제목 검색
		// %#{name}%을 기준으로 조회하므로 싸피가 포함된 유저를 전부 조회
//		for (Movie movie : movieDao.searchByTitle("해리")) {
//			System.out.println(movie);
//		}
		
		// 미출력 테스트
//		if (movieDao.searchByTitle("테스트").isEmpty()) System.out.println("찾는 영화가 없습니다.");
//		else System.out.println(movieDao.searchByTitle("테스트"));
		 
		// 영화 전체 조회
//		for (Movie movie : movieDao.selectAll()) {
//			System.out.println(movie);
//		}
		
		// 유저 테스트
		// ID에 해당하는 유저 조회
//		System.out.println(userDao.select("ssafy"));
	}
}
