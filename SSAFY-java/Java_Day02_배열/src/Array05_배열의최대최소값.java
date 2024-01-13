
public class Array05_배열의최대최소값 {

	public static void main(String[] args) {
		int[] nums = { 45, 9, 3, 7, 16, 25 };

		// 최대값과 최소값 찾기 (1) 조건문과 반복문의 콜라보
		// 최대값과 최소값 찾기 (2) 정렬해서 첫번째값, 마지막값(Arrays.sort())
		// 일단은 (1)번 방법만 사용해보자.

		int max = 0;
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (min > nums[i]) {
				min = nums[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}

}
