package java10_jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// 두 번째로 실행
public class SelectSearchTest {
	Scanner scan = new Scanner(System.in);
	
	// 변수 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "scott";
	String password = "tiger";
	
	// 첫 번째로 실행(static)
	static {
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println("드라이버 로딩 예외...");
		}
	}
	
	// 세 번째로 실행
	public SelectSearchTest() {
		employee();
	}
	
	public void employee() {
		// 이름을 입력받은 후 데이터베이스(DB) 조회하기
		try {
			// DB 연결
			conn = DriverManager.getConnection(url, username, password);
			System.out.print("사원명: ");
			String name = scan.nextLine();
			String sql = "select empno, ename, job, to_char(hiredate, 'YYYY-MM-DD') hiredate, sal from emp where ename = upper(?)"; // ? : 데이터가 변경되는 자리 
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 ? 값 세팅
			pstmt.setString(1, name); // setString(index, 값), ?값에 따라 setInt(), setDouble(), ... 로 변경
			rs = pstmt.executeQuery();
			if(rs.next()) { // 사원정보가 있을 때
				System.out.printf("%d\t %s\t %s\t %s\t %.1f\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
			} else { // 사원정보가 없을 때
				System.out.println(name+"사원은 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println("사원검색 예외 발생..."+e.getMessage());
		} finally {
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SelectSearchTest sst = new SelectSearchTest();
	}

}
