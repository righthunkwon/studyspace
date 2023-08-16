import java.util.Arrays;

public class String_04_문자열뒤집기 {
	public static void main(String[] args) {
		String text = "조용히관리하겠습니다"; // 다니습겠하리관히용조

		// 문자열 뒤집기
		// (1) 문자 배열 거꾸로 순회
		char[] ch1 = new char[text.length()];
		for (int i = text.length() - 1; i >= 0; i--) {
			ch1[text.length()-1-i] = text.charAt(i);
		}
		System.out.println(Arrays.toString(ch1));
		
		// (2) swap 방식
		// 조-다, 용-니, 히-습, 관-겠, 리-하
		// 절반만 swap하면 된다.
		char[] ch2 = text.toCharArray();
		int n = ch2.length;
		
		for (int i = 0; i < n/2; i++) {
			char tmp = ch2[i];
			ch2[i] = ch2[n-1-i];
			ch2[n-1-i] = tmp;
		}
		System.out.println(Arrays.toString(ch2));
		
		// (3) StringBuilder & StringBuffer
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		sb.reverse();
		System.out.println(sb.toString());
	}
}
