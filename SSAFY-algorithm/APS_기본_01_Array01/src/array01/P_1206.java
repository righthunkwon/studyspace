package array01;

import java.util.Scanner;

public class P_1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;

		// test case
		for (int i = 1; i <= tc; i++) {

			// 건물의 개수
			int n = sc.nextInt();
			int[] heights = new int[n];

			// 배열 입력 반복문
			for (int j = 0; j < n; j++) {
				heights[j] = sc.nextInt();
			}

			// 건물들의 높이 비교
			// 왼쪽 두 칸과 오른쪽 두 칸 모두를 비교한 후 비교하려는 index의 배열의 요소가 더 크면 cnt++
			int cnt = 0; // 조망권이 확보된 세대의 수
			for (int k = 2; k < heights.length - 2; k++) {
				int heightLeft = Math.max(heights[k - 1], heights[k - 2]); // 왼쪽 최대 높이
				int heightRight = Math.max(heights[k + 1], heights[k + 2]); // 오른쪽 최대 높이
				int height = Math.max(heightLeft, heightRight); // 주변 전체 최대 높이
				if (heights[k] < height) {
					// 대상이 주변 좌우 각 두칸의 높이보다 낮을 경우 조망권이 없으므로 continue
					continue;
				}
				// 조망권이 확보된 세대의 수 = 대상의 높이 - 주변 최대 높이
				cnt += heights[k] - height;
			}
			System.out.print("#" + i + " ");
			System.out.println(cnt);
		}
	}
}
