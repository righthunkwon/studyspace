package array01;

import java.util.Scanner;

public class P_2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] nums = new int[10];

		
		// test case
		for (int i = 0; i < tc; i++) { 
			
			// 배열 입력 반복문
			for (int j = 0; j < nums.length; j++) {
				nums[j] = sc.nextInt();
			}
			
			// bubble sort(오름차순)
			// total cycle : nums.length - 1
			// each cycle : nums.length - 1++
			for (int j = 0; j < nums.length; j++) {
				for (int k = 1; k < nums.length - j; k++) {
					if (nums[k-1] > nums[k]) {
						int tmp = nums[k];
						nums[k] = nums[k-1];
						nums[k-1] = tmp;
					}
				}
			}
			System.out.print("#" + (i+1) + " ");
			System.out.println(nums[nums.length - 1]);
		}

	}
}
