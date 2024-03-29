package array04;

import java.util.Arrays;

public class Array04_03_배열출력 {
	static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9, } };
	static int n = arr.length;

	public static void main(String[] args) {

		// 전치행렬 미구현
		// 바꿨다고 생각했는데 바꾼 뒤 또 바꿔서 원래 행렬이 된다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = tmp;
			}
		}
		
		for (int[] num : arr) {
			System.out.println(Arrays.toString(num));
		}
		System.out.println("==========");
		
		// 전치행렬 구현
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 절반 범위만 바꿔줘야 바꿨다가 또 바꾸는 일이 벌어지지 않는다.
				if (i < j) {
					int tmp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = tmp;
				}
			}
		}

		for (int[] num : arr) {
			System.out.println(Arrays.toString(num));
		}
		System.out.println("==========");
	}
}
