package array03;

import java.util.Scanner;

public class P_1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			
			// 범위 초과를 방지하기 위해 배열 크기를 좌우 2만큼 크게 생성
			int[][] arr = new int[102][102];
			int dx = 0; // 도착점의 행 index
			int dy = 0; // 도착점의 열 index
			sc.nextInt(); // test case를 입력받지 않으면 슬픕니다...
			// 배열 값 입력
			for (int i = 1; i <= 100; i++) {
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2) {
						dx = i;
						dy = j;
					}
				}
			}

			// 이동 로직
			while (true) {
				dx--;
				while (arr[dx][dy - 1] == 0 && arr[dx][dy + 1] == 0 && dx > 1) {
					dx--;
				}
				if (dx == 1) {
					break;
				}
				if (arr[dx][dy - 1] != 0) { // 왼쪽 전진
					while (arr[dx][dy - 1] != 0) dy--;
				} else if (arr[dx][dy + 1] != 0) { // 오른쪽 전진
					while (arr[dx][dy + 1] != 0) dy++;
				}
			}
			System.out.printf("#%d %d\n", t, dy-1);
		}
	}
}
