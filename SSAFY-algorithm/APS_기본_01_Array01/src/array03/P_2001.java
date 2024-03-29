package array03;

import java.util.Scanner;

public class P_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 배열의 길이
			int m = sc.nextInt(); // 파리채의 길이

			// (1) 배열 값 입력(파리 수 입력)
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// (2) 배열 탐색 후 최대값 저장
			int sum = 0; // m*m 영역의 합
			int ans = 0; // 죽은 파리의 개수
			
			// 배열 범위 초과를 막기 위해 (m-1, m-1)부터 탐색
			for(int i = m-1; i < n; i++) { 
				for (int j = m-1; j < n; j++) {
					// m*m 파리채로 죽인 파리 수의 합
					for (int k = 0; k < m; k++) {
						for (int l = 0; l < m; l++) {
							sum += arr[i-k][j-l];
						}
					}
					if (sum > ans) {
						ans = sum;
					}
					sum = 0;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
