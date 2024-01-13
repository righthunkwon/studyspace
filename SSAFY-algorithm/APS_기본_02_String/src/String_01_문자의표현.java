
public class String_01_문자의표현 {
	public static void main(String[] args) {
		char a = 'A'; // 2byte
		System.out.println(a); // A
		System.out.println((int)a); // 65
		
		int b = 'A'; // 4byte
		System.out.println(b); // 65, 자동형변환
		
		System.out.println('9'); // 9(문자)
		System.out.println((int)'9'); // 57(9의 아스키코드값)
		
		// 문자 → 숫자
		// (1) 문자 - '0'
		// (2) 문자 - 48
		System.out.println('9' - '0'); // 9(숫자)
		System.out.println('9' - 48); // 9(숫자, 0의 아스키코드 값은 48)
		
		// 참고
		System.out.println('a' - 'A'); // 32
		
		System.out.println((char)('A'^32)); // XOR 연산 : a
		System.out.println((char)('a'^32)); // XOR 연산 : A 
	}
}
