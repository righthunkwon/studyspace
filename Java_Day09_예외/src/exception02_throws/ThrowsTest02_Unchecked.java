package exception02_throws;

public class ThrowsTest02_Unchecked {
	public static void main(String[] args) {
		// method1() 사용 방법
		// 1. 내부에서 객체를 생성하거나 2. static 메소드로 변경
		
		// 내부 객체 생성
		ThrowsTest02_Unchecked t = new ThrowsTest02_Unchecked();
		try {
			t.method1();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

	}
	
	public void method1() throws ArithmeticException {
		method2();
	}
	
	// 호출한 곳으로 예외를 던진다.
	public void method2() throws ArithmeticException  {
		// Unchecked exception
		int i = 1 / 0;
	}
	
}
