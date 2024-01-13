package array02;

import java.util.Arrays;

public class Array02_02_BinarySearch {
	// 이진검색을 위한 정렬된 배열
	public static int[] arr = { 2, 4, 7, 9, 11, 19, 23 };

	public static void main(String[] args) {
		System.out.println(binarySearch(7));
		System.out.println(binarySearch(20));

		// Arrays.binarySearch가 이미 존재한다.
		System.out.println(Arrays.binarySearch(arr, 7)); // 해당 key의 index 반환
		System.out.println(Arrays.binarySearch(arr, 20)); // 찾지 못했을 경우 음수 반환
	}

	public static boolean binarySearch(int key) {
		int st = 0; // 시작점
		int ed = arr.length - 1; // 종료점

		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (key == arr[mid]) {
				return true;
			} else if (arr[mid] < key) {
				// 오른쪽으로 이동
				st = mid + 1;
			} else {
				// 왼쪽으로 이동
				ed = mid - 1;
			}
		}
		return false;
	}
}
