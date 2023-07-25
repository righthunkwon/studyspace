package com.ssafy.prac3;

public class Prac1_Direction {
	public static void main(String[] args) {
		// 1, 2, 3
		// 4, 5, 6
		// 7, 8, 9
		// 주어지는 2차원 배열
		int[][] map = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// 주어진 좌표가 r = 1, c = 1 일때 2, 8, 4, 6 순서로 출력하기
		int r = 1; // row 행
		int c = 1; // col 열

		// 상 하 좌 우 순서
		int[] dr1 = { -1, 1, 0, 0 };
		int[] dc1 = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			int nr = r + dr1[i];
			int nc = c + dc1[i];
			System.out.print(map[nr][nc] + " ");
		}
		System.out.println();

		// 상 우 하 좌 순서
		int[] dr2 = { -1, 0, 1, 0 };
		int[] dc2 = { 0, 1, 0, -1 };
		// 주어진 좌표가 r = 0, c = 1 일때 3, 5, 1 순서로 출력하기.
		r = 0;
		c = 1;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr2[i];
			int nc = c + dc2[i];
			// 상 우 하 좌 순서로 하는데 배열의 크기를 벗어나므로 넘어나지 않도록 조건문 작성
		    if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
		        System.out.print(map[nr][nc] + " ");
		    }
		}
		System.out.println();
	}
}
