package java03.operator;

public class Op02_산술연산자 {
	public static void main(String[] args) {
		// 정수와 정수의 연산은 정수가 나온다.
		// 정수와 실수의 연산은 실수가 나온다. (자동 형변환)
		
		
		// (1) 정수와 정수의 연산
		int a = 10;
		int b = 6;

		System.out.println(a + b); // 16
		System.out.println(a - b); // 4
		System.out.println(a * b); // 60
		System.out.println(a / b); // 1
		System.out.println(a % b); // 4
		
		// (2) 정수와 실수의 연산
		double c = 6.0;
		System.out.println(a + c); // 16.0
		System.out.println(a - c); // 4.0
		System.out.println(a * c); // 60.0
		System.out.println(a / c); // 1.6666666666666667
		System.out.println(a % c); // 4.0
	}
}
