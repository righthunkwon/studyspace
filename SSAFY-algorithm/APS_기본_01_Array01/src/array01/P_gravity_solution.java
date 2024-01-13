package array01;

import java.util.Scanner;

public class P_gravity_solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt(); // 박스 가로 길이
		int[] height = new int[width]; // 박스 높이

		// 박스 높이 입력 반복문
		for (int i = 0; i < width; i++) {
			height[i] = sc.nextInt();
		}
		int max = 0; // 최대 낙차
		int ans = 0; // 정답

		for (int i = 0; i < width - 1; i++) {
			// 초기화
			max = 0;

			for (int j = i + 1; j < width; j++) {
				if (height[i] > height[j]) {
					max++;
				}
				if (max > ans) {
					ans = max;
				}
			}
		}
		System.out.println(ans);
	}
}
