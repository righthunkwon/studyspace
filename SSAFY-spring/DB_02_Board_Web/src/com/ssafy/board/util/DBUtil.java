package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQL DB 연결 객체를 제공하고, 사용했던 자원을 해제하는 기능을 제공하는 클래스
 */
public class DBUtil {
	// DBUtil
	// (1) getConnection
	// (2) close
	
	/**
	 * DB 접속에 필요한 url을 작성한다.  
	 * url은 jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]의 구조로 작성한다. 
	 * serverTimezone=UTC 설정이 없으면 오류가 발생하므로 주의한다.
	 */
	// DB와 연결하기위해 필요한 DB의 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	
	// DB의 USER 이름
	private final String username = "ssafy";
	// 위의 USER의 PASSWORD
	private final String password = "ssafy";
	// Mysql 드라이버 클래스 이름
	private final String driverName = "com.mysql.cj.jdbc.Driver";

	/**
	 * Singleton Design Pattern을 적용
	 */
	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		// JDBC 드라이버 로딩
		// 드라이버 로딩은 객체 생성 시 한번만 진행하
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	/**
	 * DriverManager를 통해 Connection을 생성하고 반환
	 *
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 사용한 리소스들을 정리하는 close 메소드
	 * Connection, Statement, ResultSet 모두 AutoCloseable 타입으로 스프레드 연산자(...)를 이용하여
	 * 삭제할 수 있다.
	 *
	 * @param closeables
	 */
	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}