package exception02_throws;

public class ThrowsTest01_Checked {
	public static void main(String[] args) {
		// method1() 사용 방법
		// 1. 내부에서 객체를 생성하거나 2. static 메소드로 변경
		
		// 내부 객체 생성
		ThrowsTest01_Checked t = new ThrowsTest01_Checked();
		try {
			t.method1();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void method1() throws ClassNotFoundException {
		method2();
	}
	
	// 호출한 곳으로 예외를 던진다.
	public void method2() throws ClassNotFoundException {
		// Checked exception
		Class.forName("SSAFY"); 
	}
}
