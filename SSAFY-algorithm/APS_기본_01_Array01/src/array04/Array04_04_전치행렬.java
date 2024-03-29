package array04;

import java.util.Arrays;

public class Array04_04_전치행렬 {
	static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9, } };
	static int n = arr.length;

	public static void main(String[] args) {

		// 출력 방법 1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// 출력 방법 2
		for (int[] num : arr) {
			System.out.println(Arrays.toString(num));
		}
		
		// 출력 방법 3
		System.out.println(Arrays.deepToString(arr));
	}
}
