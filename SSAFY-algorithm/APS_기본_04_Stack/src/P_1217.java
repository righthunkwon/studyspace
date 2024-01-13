import java.util.Scanner;

// 거듭제곱
public class P_1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			sc.nextInt(); // test case 입력
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.printf("#%d %d\n", t, power(n, m));
		}
	}
	
	// base를 exponent회 만큼 곱한다(재귀함수의 호출횟수 = exponent).
	private static int power(int base, int exponent) {
		if (exponent <= 0) return 1;
		return base * power(base, exponent - 1);
	}
}
