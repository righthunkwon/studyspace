package java10_jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	// DB 연결과 관련된 파일들은 해당 파일에 상속받아 사용했다. 
	
	// 멤버변수
	// protected로 선언하여 다른 패키지에서 접근할 때 상속하여서만 사용할 수 있게 만들었다.
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	
	protected String sql = null;
	
	// 드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("드라이브 로딩 예외 발생...");
			e.printStackTrace();
		}
	}
	
	// DB 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("DB 연결 예외 발생...");
			e.printStackTrace();
		}
	}
	
	// DB 닫기
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("DB 닫기 예외 발생...");
			e.printStackTrace();
		}
	}
}
