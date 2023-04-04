package test01.control;

public class NumberReverseSol {

	public NumberReverseSol() {

	}

	// API 클래스 이용
	static void numberReverse(int data) {
		StringBuilder sb = new StringBuilder(String.valueOf(data));
		sb.reverse();
		System.out.println(sb.toString());
	}

	// 배열 이용
	static void numberReverseArray(int data) {
		StringReverseArray(String.valueOf(data));
	}

	static void StringReverseArray(String data) {
		char[] c = data.toCharArray();

		// 배열의 문자 교환
		for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = temp;
		}
		System.out.println(String.valueOf(c));
	}

	public static void main(String[] args) {
		// (1) API 클래스 이용
		numberReverse(123456);

		// (2) 배열 이용
		numberReverseArray(123456789);
		StringReverseArray("Java Algorithm");
	}

}

	/*
			숫자를 문자로 : String.valufOf(int n); , 숫자+"문자" 
			문자를 숫자로 : Integer.parseInt("String s") 
			숫자 + 문자열 : 문자열(데이터 타입)
	*/
