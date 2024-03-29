package array03;

public class Array03_03_2차원배열 {
	public static void main(String[] args) {
		// 1 2 3
		// 4 5 6
		// 7 8 9
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = arr.length;
		int m = arr[0].length;

		// 1. 행우선순회(정방향)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 2. 행우선순회(역방향)
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 2. 행우선순회(역방향, idx를 수정)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%3d", arr[i][m - 1 - j]);
			}
		}
		System.out.println();

		// 3. 열우선순회(정방향)
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 3. 열우선순회(역방향)
		for (int j = 0; j < m; j++) {
			for (int i = n - 1; i >= 0; i--) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 4. 지그재그순회
		// 짝수일 때 정방향, 홀수일 때 역방향
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					System.out.printf("%3d", arr[i][j]);
				}
			}
		}
		System.out.println();

		// 4. 지그재그순회(개선)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%3d", arr[i][j + (m - 1 - 2 * j) * (i % 2)]);
			}
		}
		System.out.println();
	}
}
