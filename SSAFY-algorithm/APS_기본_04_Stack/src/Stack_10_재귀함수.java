
public class Stack_10_재귀함수 {
	public static void main(String[] args) {
		func(10);
	}
	
	// 재귀함수는 보통 두 파트로 작성한다.
	private static void func(int num) {
		// 1. 기본파트 : 재귀함수를 종료하는 조건을 작성하는 부분
		// num == 0 보다는 num <= 0가 좀 더 안정적이다.
		if (num <= 0) {
			return;
			
		// 2. 재귀파트 : 나 자신을 (자신처럼 보이는 함수를) 다시 호출하는 부분
		} else {
			System.out.println(num + " 함수 호출");
			func(num - 1);
			System.out.println(num + " 함수 리턴");
		}
		
	}
}
