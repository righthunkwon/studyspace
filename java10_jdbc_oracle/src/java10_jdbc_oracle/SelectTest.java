package java10_jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		start();
	}
	public void start() {
		// oracle 데이터베이스의 레코드 선택하기
		// 초기값 설정
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버를 자바가상 머신에 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";  // @localhost:port:sid
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (DB주소, 아이디, 비밀번호)
			// 3. SQL문 작성 후 Statement 생성
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp "
					+ "order by ename asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// executeUpdate()	: insert, uptate, delete문 실행
			// executeQuery() 	: select문 실행
			// 레코드가 있으면 true, 레코드가 없으면 false
			while(rs.next()) { // next() 현재 포인트의 레코드를 얻어온다.
				int empno = rs.getInt(1); 		// rs.getInt("empno");
				String ename = rs.getString(2); // rs.getString("ename");
				String job = rs.getString(3);	// rs.getString("job");
				int mgr = rs.getInt(4); 		// rs.getInt("mgr")
				String hiredate = rs.getString(5); // rs.getString("hiredate");
				double sal = rs.getDouble(6);	   // rs.getDouble("sal");
				double comm = rs.getDouble(7); 	   // rs.getDouble("comm");
				int deptno = rs.getInt(8); 	       // rs.getInt("deptno");
				
				System.out.println(empno+"\t"+ename+"\t"+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno+"\t"+job);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC 드라이버 오류..."+ cnfe.getMessage());
		} catch (SQLException sqle) {
			System.out.println("데이터베이스 연결 예외 발생..."+sqle.getMessage());
		} finally {
			try {
				// 데이터베이스 닫기
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("데이터베이스 닫기 예외 발생..."+sqle.getMessage());
			}
		}
	}
	public static void main(String[] args) {
		new SelectTest();
	}

}
