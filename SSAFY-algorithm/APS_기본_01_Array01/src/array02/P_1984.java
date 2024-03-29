package array02;

import java.util.Scanner;

public class P_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 10; // 도수 10
		int[] arr = new int[n]; // 길이 10의 배열

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int avg = 0; // 평균

			// 배열에 값 삽입
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// 최대값 최소값 제외한 평균 계산(선택정렬)
			for (int i = 0; i < n - 1; i++) {
				int minIdx = i; // 최소값을 가진 인덱스를 초기화

				// 최소값을 가리키는 인덱스 검색
				for (int j = i + 1; j < n; j++) {
					if (arr[j] < arr[minIdx]) {
						minIdx = j;
					}
				}

				// 자리 교환
				int tmp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;

				// 최대값과 최소값을 제외한 평균 계산
				int sum = 0; // 합
				for (int k = 1; k < n - 1; k++) {
					sum += arr[k];
				}
				avg = (int) Math.round((double) sum / (n - 2)); // 종재 goat said : 괄호를 넣어라 (연산자 우선순위)
			}

			// 출력
			System.out.printf("#%d %d\n", t, avg);
		}

	}
}
