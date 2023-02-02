package java10_jdbc_oracle;
import java.util.Scanner;

public class DeleteTest extends DBConnection{
	Scanner scan = new Scanner(System.in);

	public DeleteTest() {
		
	}
	
	public void start() {
		try {
			System.out.print("삭제할 사원명: ");
			String ename = scan.nextLine();
			getConnection(); // DB 연결
			
			sql = "delete from emp2 where ename = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(ename+" 사원의 정보가 삭제되었습니다.");
			} else {
				System.out.println(ename+" 사원은 존재하지 않습니다.");
			}
			// 삭제할 때는 필드명을 별도로 기술할 필요가 없다.
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteTest().start();
	}

}
