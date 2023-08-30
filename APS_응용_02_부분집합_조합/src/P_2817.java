import java.util.Scanner;

// 부분 수열의 합
public class P_2817 {
	static int n, k, ans;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			ans = 0; // test case 마다 ans 초기화

			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n];

			// 배열 요소 입력
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// 재귀
			recursion(0, 0);

			// 출력
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	// 재귀는 '믿음'이다.
	private static void recursion(int idx, int sum) {
		if (idx == n) {
			if (sum == k) {
				ans++;
			}
			return;
		}

		recursion(idx+1, sum);
		recursion(idx+1, sum + arr[idx]);
	}
}