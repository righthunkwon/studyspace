package array02;

import java.util.Arrays;

public class Array02_03_SelectionSort {
	public static void main(String[] args) {
		int[] arr = { 64, 25, 10, 22, 11 };
		int n = arr.length;

		// 선택 정렬은 버블 정렬과 마찬가지로 n - 1 만큼의 사이클의 정렬을 거친다.
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i; // 최소값을 가진 인덱스를 초기화

			// 최소값을 가리키는 idx 검색
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			
			// 자리 교환
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
