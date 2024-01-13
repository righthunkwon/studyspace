package array01;

public class Array01_01_배열순회 {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 4, 5 };

		///////////////////////////////////////////
		// 1. 정방향순회
		// 1-1. 반복문
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		System.out.println("-----------------");

		// 1-2. 향상된 반복문 (readonly)
		for (int num : nums) {
			System.out.println(num);
		}
		System.out.println("-----------------");

		
		///////////////////////////////////////////
		// 2. 역방향 순회
		// 2-1. 마지막 idx부터 0까지
		for (int i = nums.length - 1; i >= 0; i--) {
			System.out.println(nums[i]);
		}
		System.out.println("-----------------");

		// 2-2. idx를 직접 조정하여 순회
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[nums.length - 1 - i]);
		}
		System.out.println("-----------------");

		
		///////////////////////////////////////////
		// 3. 특정 지점에서 양옆으로 나아가며 순회(반복횟수를 모르므로 while문이 좀 더 편리)
//		int startPoint = 3; // 시작포인트
//		int i = 1; // 증가량

		
	}
}
