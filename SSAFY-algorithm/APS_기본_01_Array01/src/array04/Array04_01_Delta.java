package array04;

public class Array04_01_Delta {
	static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9, } };
	static int n = arr.length;

	public static void main(String[] args) {
		// 현재 나의 좌표(3*3배열의 중앙, 5에 위치)
		int r = 1;
		int c = 1;

		// Delta
		// 문제에서 주어진 방향이 있으면 그것을 따르고, 없으면 자유롭게 구현

		// 상하좌우로 델타 구현
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int d = 0; d < 4; d++) {
			// d = 0, 1, 2, 3
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 1 2 3 
			// 4 5 6 
			// 7 8 9 
			System.out.println(arr[nr][nc]);
		}
	}
}
