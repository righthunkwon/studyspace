package java10_jdbc_oracle;

import java.util.Scanner;

public class UpdateTest extends DBConnection {
	Scanner scan = new Scanner(System.in);
	
	public UpdateTest() {
		
	}

	public void start() {
		// 수정할 사원번호 입력
		// 담당업무, 급여, 보너스 수정
		
		try {
			System.out.print("수정할 사원번호: ");
			int empno = Integer.parseInt(scan.nextLine());
			
			System.out.print("담당업무: ");
			String job = scan.nextLine();
			
			System.out.print("급여: ");
			double sal = Double.parseDouble(scan.nextLine());
			
			System.out.print("보너스: ");
			double comm = Double.parseDouble(scan.nextLine());
			
			System.out.println(empno+","+job+","+sal+","+comm);
			getConnection();
			
			sql = "update emp2 set job=?, sal=?, comm=? where empno=?";
			pstmt = conn.prepareStatement(sql);

			// ? 값 세팅
			pstmt.setString(1, job);
			pstmt.setDouble(2, sal);
			pstmt.setDouble(3, comm);
			pstmt.setInt(4, empno);

			// 실행
			// executeUpdate()	 : insert문, update문, delete문 실행
			// executeQuery()	 : select문 실행
			int result = pstmt.executeUpdate(); // update
			if(result > 0) {
				System.out.println(empno+"번 사원의 정보가 수정되었습니다.");
			} else {
				System.out.println("해당 사원번호가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		ut.start();
	}

}
