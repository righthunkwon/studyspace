import java.util.Scanner;

// 거듭 제곱
public class S_1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// test case
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			sc.nextInt(); // test case 입력

			int n = sc.nextInt(); // 밑
			int m = sc.nextInt(); // 지수

			System.out.printf("#%d %d\n", t, power(n, m));
		}
	}

	private static int power(int base, int exponent) {
		// 기저부분(종료조건)
		if (exponent == 0) {
			return 1;
		}

		// 재귀부분(반복수행)
		int tmp;

		// 제곱수가 짝수일 때
		if (exponent % 2 == 0) {
			tmp = power(base, exponent / 2);
			return tmp * tmp;
		}

		// 제곱수가 홀수일 때
		else {
			tmp = power(base, (exponent-1) / 2);
			return tmp * tmp * base;
		}
	}
}
