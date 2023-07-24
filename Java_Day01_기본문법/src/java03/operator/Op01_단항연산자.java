package java03.operator;

public class Op01_단항연산자 {
	// 다음 중 올바른 값을 채워 넣으시오.
	public static void main(String[] args) {
		int a = 5;
		System.out.println( a++ );  // 5
		System.out.println( ++a );	// 7
		System.out.println( --a );	// 6
		System.out.println( a );	// 6
		System.out.println( a-- );	// 6
		System.out.println( a++ );	// 5
		
		System.out.println(-a);		// -6
		System.out.println(~a);		// -7, ~ : 비트 부정 연산자
		
		System.out.println(!false); // true, ! : 논리 부정 연산자
	}
}
