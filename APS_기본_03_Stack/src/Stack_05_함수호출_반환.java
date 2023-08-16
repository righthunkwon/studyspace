
public class Stack_05_함수호출_반환 {

	// [stack] function call
	public static void main(String[] args) {
		System.out.println("메인함수 실행");
		func1();
		System.out.println("메인함수 종료");
	}

	private static void func1() {
		int n = 10; // 지역변수
		System.out.println("함수1 실행");
		System.out.println("n: " + func2(n)); // 20
		System.out.println("함수1 종료");
	}

	private static int func2(int n) { // 매개변수
		n = 20; // 지역변수이므로 func2에만 유효
		System.out.println("함수2 실행");
		System.out.println("함수2 종료");
		return n; // 반환값이므로 지역변수의 값이라도 메소드 밖에서 사용 가능
	}
}
