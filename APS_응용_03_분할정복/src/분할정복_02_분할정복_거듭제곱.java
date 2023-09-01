
public class 분할정복_02_분할정복_거듭제곱 {
	public static void main(String[] args) {
		int base = 2;
		int exponent = 10;

		// 거듭제곱을 구하는 메소드
		System.out.println(power(base, exponent));
	}

	private static int power(int base, int exponent) {
		// 기저부분(종료조건)
		if (exponent == 0) {
			return 1;
		}

		// 재귀부분(반복수행)
		// 호출 횟수를 줄이기 위해 이미 호출한 재귀함수 부분의 값을 저장해두면 더 좋다(메모라이제이션).
		
		// 제곱수가 짝수일 때
		if (exponent % 2 == 0) {
			return power(base, exponent / 2) * power(base, exponent / 2);
		}

		// 제곱수가 홀수일 때
		else {
			return power(base, (exponent - 1) / 2) * power(base, (exponent - 1) / 2 ) * base;
		}
	}
}
