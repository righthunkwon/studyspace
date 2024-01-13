
public class Stack_09_재귀함수 {
	public static int cnt = 0;
	public static void main(String[] args) {
		func();
	}
	
	private static void func() {
		System.out.println(cnt++); // 스택의 깊이 확인
		func(); // 무한히 호출되지만 정해진 메모리가 초과되면 스택오버플로우가 발생한다.
	}
	

 }
