import java.util.Arrays;

public class String_03_문자열은문자배열 {
	public static void main(String[] args) {
		// 문자열은 문자의 배열이다
		String str = "abc";
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		// System.out.println(str.charAt(3)); // java.lang.StringIndexOutOfBoundsException 예외 발생
		
		char[] ch = str.toCharArray();
		System.out.println(Arrays.toString(ch)); // [a, b, c]
	}
}