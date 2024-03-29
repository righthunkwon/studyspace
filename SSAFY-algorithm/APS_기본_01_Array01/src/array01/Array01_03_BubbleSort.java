package array01;
import java.util.Arrays;

public class Array01_03_BubbleSort {
	public static void main(String[] args) {
		// 오름차순 버블정렬
		// 요소가 N개 일때 최대 N-1번의 사이클을 돌면 요소를 정렬할 수 있다.

		int[] nums = { 24, 99999, 99, 31, 213124, 7, 35 };
		// 1번 사이클 24 99 31 99999 7 35 213124 (213124는 정렬이 되었음을 확신)
		// 2번 사이클 24 31 99 7 35 99999 213124 (99999도 정렬이 되었음을 확신)
		// 3번 사이클 24 31 7 35 99 99999 213124 (99도 정렬이 되었음을 확신)
		// 4번 사이클 24 7 31 35 99 99999 213424 (35 정렬)(31정렬)
		// 5번 사이클 7 24 31 35 99 99999 213424 (24 정렬)
		// 6번 사이클 (불필요)

		// 사이클 반복 (nums.length - 1)
		for (int i = 0; i < nums.length - 1; i++) {
			// Bubble Sort(오름차순)
			for (int j = 1; j < nums.length - i; j++) {
				if (nums[j - 1] > nums[j]) {
					int tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
