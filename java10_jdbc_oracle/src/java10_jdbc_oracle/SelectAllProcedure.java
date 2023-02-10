package java10_jdbc_oracle;

import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;

public class SelectAllProcedure extends DBConnection {

	public SelectAllProcedure() {
		
	}
	
	public void selectAllStart() {
		try {
			getConnection();
			
			sql = "{call book_all_select(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			// 실행
			cstmt.executeLargeUpdate();
			
			// 첫번째 ?에 담긴 레코드 꺼내기
			rs = (ResultSet)cstmt.getObject(1);
			
			// b.isbn, b.bookname, b.price, b.pub_date, b.category, b.stock, a.author, p.pub_name, p.pub_tel
			while (rs.next()) {
				System.out.printf("%d, %s, %d, %s, %s, %d, %s, %s, %s\n", 
								rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), 
								rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}

	public static void main(String[] args) {
		new SelectAllProcedure().selectAllStart();
	}

}
