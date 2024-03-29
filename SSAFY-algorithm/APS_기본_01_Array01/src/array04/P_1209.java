package array04;

import java.util.Scanner;

public class P_1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		for (int t = 1; t <= 10; t++) {

			// test case 입력
			sc.nextInt();
			
			// 배열 입력
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 행과 열의 합
			int sum = 0; // 행과 열의 최대합
			int rsum = 0, csum = 0; // 행과 열의 합
			int rtmp = 0, ctmp = 0; // 행과 열의 임시합
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					rtmp += arr[i][j];
					ctmp += arr[j][i];
				}
				rsum = Math.max(rsum, rtmp);
				csum = Math.max(csum, ctmp);
				rtmp = 0;
				ctmp = 0;
			}
			sum = Math.max(rsum, csum);

			// 대각선의 합
			int tmp = 0;
			int dlsum = 0; // 왼쪽에서 출발하는 대각선의 합
			int drsum = 0; // 오른쪽에서 출발하는 대각선의 합
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (i == j) {
						tmp += arr[i][j];
						dlsum = Math.max(dlsum, tmp);
					}
					if (i + j == 99) {
						tmp += arr[i][j];
						drsum = Math.max(drsum, tmp);
					}
				}
				tmp = 0;
			}

			// 최대합 판별
			int ans = Math.max(sum, Math.max(dlsum, drsum));
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
