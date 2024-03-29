package array02;

import java.util.Scanner;

public class P_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n]; 
			
			// 숫자열을 배열에 저장
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			// Counting Sort
			// 1. 배열의 최대값 구하기
			int k = -1; // 최대값 초기화
			for (int i = 0; i < n; i++) {
				if (k < arr[i]) {
					k = arr[i];
				}
			}
			
			// 2. 개수를 세는 도수분포표 만들기 
			int[] cnt = new int[k + 1]; // 도수분포 배열
			for (int i = 0; i < n; i++) {
				// 해당 값을 인덱스로 하여 카운트를 증가시킨다.
				cnt[arr[i]]++;
			}

			// 3. 누적합을 계산한 누적도수분포표 문들기
			for (int i = 1; i < cnt.length; i++) {
				cnt[i] += cnt[i - 1];
			}

			// 4. 원본배열의 뒤에서부터 순회를 하며 배열에 저장
			int[] sortArr = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				sortArr[--cnt[arr[i]]] = arr[i];
			}
			
			System.out.printf("#%d ", t);
			for (int i = 0; i < n; i++) {
				System.out.print(sortArr[i] + " ");
			}
			System.out.println();
		}
	}
}
