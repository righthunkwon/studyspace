
public class String_02_문자열생성 {
	public static void main(String[] args) {
		// 기본
		String str1 = "abc";
		String str2 = new String("abc");

		System.out.println(str1); // abc
		System.out.println(str2); // abc
		
		System.out.println(str1 == str2); // false
		System.out.println(str1.equals(str2)); // true
		
		// 심화
		String str3 = "abc";
		String str4 = str2;
		String str5 = str3;
		
		System.out.println(str1 == str3); // true
		System.out.println(str2 == str4); // true
		System.out.println(str3 == str5); // true
		
		System.out.println(str1.equals(str3)); // true
		System.out.println(str2.equals(str4)); // true
		System.out.println(str3.equals(str5)); // true
		
		// 결론
		// 문자열의 비교는 == 대신에 equals()를 활용하자
	}
	
}
