package java10_jdbc_oracle;

import java.sql.Types;
import java.util.Scanner;
	
public class InsertProcedure extends DBConnection{ // DB 연결을 위한 상속
	Scanner scan = new Scanner(System.in);
	public InsertProcedure() {
		
	}
	
	public void insertStart() {
		// 콘솔에서 책정보를 입력받아 DB에 등록하는 클래스(17_scott)
		// 책정보 = 책이름, 가격, 출판일, 카테코리, 작가명, 출판사명, 재고
		System.out.print("도서명: ");
		String bookname = scan.nextLine();
		
		System.out.print("가격: ");
		int price = Integer.parseInt(scan.nextLine());
		
		System.out.print("출판일(예:2023-01-01): ");
		String pub_date = scan.nextLine();
		
		System.out.print("카테고리: ");
		String category = scan.nextLine();
		
		System.out.print("작가명: ");
		String author = scan.nextLine();
		
		System.out.print("출판사명: ");
		String pub_name = scan.nextLine();
		
		System.out.print("재고: ");
		int stock = Integer.parseInt(scan.nextLine());
		
		try {
			// DB연결
			getConnection();
			
			
			// 프로시저 호출(17_scott)
			// sql = "{call 프로시저명(값1, 값2, ...}";
			// 값은 매개변수 갯수와 동일해야 한다(프로시저 내에는 책정보(7) + result(1) 총 8개의 매개변수 존재)
			sql = "{call booksInsert(?, ?, ?, ?, ?, ?, ?, ?)}";
			
			cstmt = conn.prepareCall(sql);
			
			// in 데이터 세팅(result를 제외)
			cstmt.setString(1, bookname);
			cstmt.setInt(2, price);
			cstmt.setString(3, pub_date);
			cstmt.setString(4, category);
			cstmt.setString(5, author);
			cstmt.setString(6, pub_name);
			cstmt.setInt(7, stock);
			
			// out 데이터 세팅(result)
			cstmt.registerOutParameter(8, Types.INTEGER);
			
			// 실행
			cstmt.executeUpdate();
			
			// 실행 결과
			if(cstmt.getInt(8) > 0) { // 도서가 등록된 경우
				System.out.println(bookname+"이/가 등록되었습니다.");
			} else { // 도서 등록이 실패한 경우
				System.out.println(bookname+"이/가 등록되지 않았습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	

	
	public static void main(String[] args) {
		// 객체 생성 후 메소드 호출
		InsertProcedure ip = new InsertProcedure();
		ip.insertStart();
	}

}
