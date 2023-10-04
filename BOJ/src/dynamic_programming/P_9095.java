package dynamic_programming;

import java.util.Scanner;

// 1, 2, 3 더하기

// 동적 계획법
// 작은 부분문제들의 최적해를 이용하여 큰 문제의 해를 구하는 방법
public class P_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] dp = new int[11];
			dp[1] = 1; // 1
			dp[2] = 2; // 1+1, 2
			dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
			
			// DP
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}
}