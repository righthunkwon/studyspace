package exception03_finally;

import java.io.FileInputStream;

public class FinallyTest03 {
	public static void main(String[] args) {
		
		// 자동 자원 반납 구문(try with resources)
		// try 괄호 안에 객체를 생성하는 코드를 작성하면 해당 객체는 close()를 호출하지 않아도 자동으로 이를 호출
		try (FileInputStream fis = new FileInputStream("test.txt")) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}