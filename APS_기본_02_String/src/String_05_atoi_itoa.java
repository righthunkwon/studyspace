
public class String_05_atoi_itoa {
	public static void main(String[] args) {
		// 문자열 → 숫자
		String snum1 = "1234";
		String snum2 = " 1234 ";
		int num1 = Integer.parseInt(snum1);
		int num2 = Integer.parseInt(snum2.trim()); // trim이 없다면 java.lang.NumberFormatException 발생
		System.out.println(num1);
		System.out.println(num2);

		// 숫자 → 문자열
		int num = 4321;
		String snum3 = num + "";
		String snum4 = String.valueOf(num);

		System.out.println(snum3);
		System.out.println(snum4);

		// 메소드 확인
		System.out.println(atoi("1234"));
		System.out.println(atoi("4321"));

	}

	// 문자열 → 숫자
	public static int atoi(String text) {
		int value = 0;
		int digit = 0;
		for (int i = 0; i < text.length(); i++) {
			char num = text.charAt(i);
			if (num >= '0' && num <= '9') { // 숫자 O
				digit = num - '0';
			} else { // 숫자 X
				System.out.println("숫자가 아닙니다");
				break;
			}
			value = (value * 10) + digit;
		}

		return value;
	}

}
