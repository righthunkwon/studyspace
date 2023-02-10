package java10_jdbc_oracle;

public class SelectAllProcedure extends DBConnection {

	public SelectAllProcedure() {
		
	}
	
	public void selectAllStart() {
		try {
			getConnection();
			
			sql = "{call book_all_select(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			
			
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
