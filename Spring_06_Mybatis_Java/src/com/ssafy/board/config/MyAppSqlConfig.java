package com.ssafy.board.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {

	// MyBatis 설정 파일 가져오기
	// 싱글턴으로 session을 가져온다.
	// private하게 생성 후 이후 public한 getSession 메소드를 활용하여 가져온다.
	private static SqlSession session;

	// mybatis 설정 파일을 세팅하는 코드
	static {
		try {
			// xml에서 SqlSessionFactory 빌드하기
			// 모든 mybatis 애플리케이션은 SqlSessionFactory 인스턴스를 사용한다. 
			// SqlSessionFactory인스턴스는 SqlSessionFactoryBuilder를 사용하여 만들수 있다. 
			String resource = "config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource); 
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

			// true 옵션 시 자동으로 커밋
			session = sqlSessionFactory.openSession(true);
			System.out.println("세션 생성 성공");
		} catch (IOException e) {
			System.out.println("세션 생성 실패");
		}
	}

	// 싱글턴 메소드
	public static SqlSession getSession() {
		return session;
	}
}
