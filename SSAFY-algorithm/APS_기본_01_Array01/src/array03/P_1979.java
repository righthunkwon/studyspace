package array03;

import java.util.Scanner;

public class P_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 배열 길이
			int k = sc.nextInt(); // 단어 길이
			int[][] arr = new int[n][n]; // n*n 배열

			// 배열 값 입력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int cnt = 0; // 단어 길이 검사 변수
			int ans = 0; // 단어가 들어갈 수 있는 자리수

			// 배열 탐색(가로)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 1일 경우 단어 길이 증가
					if (arr[i][j] == 1) {
						cnt++;
					} else if (arr[i][j] == 0 && cnt >= 1) {
						// 0일 경우 cnt가 1보다 클 때 단어 길이 일치 여부 검사
						if (cnt == k) {
							ans++; // 자리수 증가
						}
						cnt = 0; // 초기화
					}
				}
				// 마지막 열 고려
				// 배열을 만약에 한 줄 더 추가할 경우 0으로 초기화가 되므로 마지막 열을 고려하는 조건문을 추가해주지 않아도 된다.
				// 메모리를 여유있게 만드는 습관을 들이는 것도 좋을 것이다.
				if (cnt == k) {
					ans++;
				}
				cnt = 0;
			}

			// 배열 탐색(세로)
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					// 1일 경우 단어 길이 증가
					if (arr[i][j] == 1) {
						cnt++;
					} else if (arr[i][j] == 0 && cnt >= 1) {
						// 0일 경우 cnt가 1보다 클 때 단어 길이 일치 여부 검사
						if (cnt == k) {
							ans++; // 자리수 증가
						}
						cnt = 0; // 초기화
					}
				}
				// 마지막 열 고려 
				if (cnt == k) {
					ans++;
				}
				cnt = 0;
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
