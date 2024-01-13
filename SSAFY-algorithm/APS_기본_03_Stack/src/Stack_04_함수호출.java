
public class Stack_04_함수호출 {
	// [stack] function call
	public static void main(String[] args) {
		System.out.println("메인함수 실행");
		func1();
		System.out.println("메인함수 종료");
	}
	
	private static void func1() {
		int n = 10; // 지역변수
		System.out.println("함수1 실행");
		func2(n);
		System.out.println("n: " + n); // 10
		System.out.println("함수1 종료");
	}
	
	private static void func2(int n) { // 매개변수
		n = 20; // 지역변수이므로  func2에만 유효
		System.out.println("함수2 실행");
		System.out.println("함수2 종료");
		// return을 활용할 경우 n을 활용할 수 있다.
	}
}