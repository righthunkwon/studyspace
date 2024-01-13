package array01;

import java.util.Scanner;

public class P_2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 전체 점수의 개수
		int m = (n / 2); // 중간값의 index (n번째와 n번째 index는 1차이가 남에 유의!)
		int[] nums = new int[n];

		// 1 2 3 4 5 6 7 8 9	
		// 배열 입력 반복문
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		// bubble sort(오름차순)
		// total cycle 	: nums.length - 1
		// each cycle 	: nums.length - 1++ (1, 2, 3, 4, ...)
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - i; j++) {
				if (nums[j - 1] > nums[j]) {
					int tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			}
		}
		System.out.println(nums[m]);
	}
}
