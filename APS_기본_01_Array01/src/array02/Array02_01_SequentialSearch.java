package array02;

import java.util.Arrays;

public class Array02_01_SequentialSearch {
	public static int[] arr = { 4, 9, 11, 23, 2, 19, 7 };

	public static void main(String[] args) {
		// 정렬 X
		System.out.println(searchForNoSort(2));
		System.out.println(searchForNoSort(3));
		System.out.println(searchWhileNoSort(2));
		System.out.println(searchWhileNoSort(3));
		
		// 정렬 O
		Arrays.sort(arr);
	}

	public static boolean searchForNoSort(int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean searchWhileNoSort(int key) {
		int idx = 0;
		while (idx < arr.length) {
			if (arr[idx] == key) {
				return true;
			}
			idx++;
		}
		return false;
	}
	
	// 메소드 직접 작성해보기
	public static boolean searchForSort(int key) {
		return false;
	}
	
	public static boolean searchWhileSort(int key) {
		return false;
	}
}
