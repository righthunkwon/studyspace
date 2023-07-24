package java03.operator;

public class Op03_비교연산자 {
	// 이상, 이하, 초과, 미만 구분할 것
	public static void main(String[] args) {
		int a = 10;

		System.out.println(a > 10); // false
		System.out.println(a >= 10); // true
		System.out.println(a == 10); // true
		System.out.println(a != 10); // false
		System.out.println("-------------------------");

		// 문자열의 비교(equals() 메소드 사용)
		// 자바에서는 문자열의 경우에만 객체로 선언하지 않고도 사용할 수 있게 허용한다.
		String c = "Hi";
		String d = "Hi";
		String e = new String("Hi");
		
		System.out.println(c == d);
		System.out.println(c == e);
		System.out.println(d == e);
		System.out.println(c.equals(d));
		System.out.println(c.equals(e));
		System.out.println(d.equals(e));
	
	}
}
