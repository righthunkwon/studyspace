package java10_jdbc_oracle;

import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class SelectSearchProcedure extends DBConnection {
	Scanner scan = new Scanner(System.in);

	public SelectSearchProcedure() {

	}

	public void searchStart() {
		while (true) {
			try {
				// 검색어 입력
				System.out.print("검색할 도서명: ");
				String word = scan.nextLine();
				
				getConnection();
				
				sql = "{call book_search(?, ?)}";
				
				cstmt = conn.prepareCall(sql);
				cstmt.setString(1, word);
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				
				cstmt.executeLargeUpdate();
				rs = (ResultSet)cstmt.getObject(2);
				
				while(rs.next()) {
					System.out.printf("%d, %s, %d, %s, %s\n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
		}
	}

	public static void main(String[] args) {
		new SelectSearchProcedure().searchStart();
	}

}
