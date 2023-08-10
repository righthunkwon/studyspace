package array04;

import java.util.Scanner;

public class P_1954 {
	// 오른쪽 아래쪽 왼쪽 위쪽
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	// 방향 전환
	static int dir = 0;

	static void changeDir() {
		dir = (dir + 1) % 4;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			dir = 0; // static 변수 초기화(★★★★★)(
			
			// 배열 생성
			int r = 0; // 행
			int c = 0; // 열
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			// 배열에 값 집어넣기
			int cnt = 1; // 값
			while (cnt <= n * n) {
				arr[r][c] = cnt;
				
				// 조건 판단
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (0 > nr || nr >= n || 0 > nc || nc >= n || arr[nr][nc] != 0) {
					changeDir();
				}
				
				// 행 열 추가
				r += dr[dir];
				c += dc[dir];
				
				// 값 증가
				cnt++;
			}

			// 출력
			System.out.printf("#%d\n", t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
