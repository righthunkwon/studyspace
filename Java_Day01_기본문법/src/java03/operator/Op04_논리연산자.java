package java03.operator;

public class Op04_논리연산자 {
	//단축평가 고려하여 조건 나열
	public static void main(String[] args) {
		int a = 10;
		int b = 20; 
		
		System.out.println(a > 5 && b > 5); 	// true
		System.out.println(a > 5 && b < 5);		// false
		System.out.println(a < 5 && b > 5);		// false
		System.out.println(a < 5 && b < 5);		// false
		
		System.out.println(a > 5 || b > 5);		// true
		System.out.println(a > 5 || b < 5);		// true
		System.out.println(a < 5 || b > 5);		// true
		System.out.println(a < 5 || b < 5);		// false
		
		System.out.println(!(a < 5 || b < 5));	// true
	}
}
