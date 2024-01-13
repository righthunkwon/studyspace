import java.util.Arrays;

public class Array04_배열의복사 {
	public static void main(String[] args) {
		int[] nums = { 45, 9, 3, 7, 16, 25 };
		
		// 배열의 복사 (1) 반복문
		int[] tmp = new int[nums.length*2]; // 원 배열의 두 배로 복사
		for(int i=0; i<nums.length; i++) {
			tmp[i] = nums[i];
		}
		System.out.println(Arrays.toString(tmp));
		
		// 배열의 복사 (2) Arrays.copyOf(원본배열, 복사할 배열의 크기)
		int[] tmp2 = Arrays.copyOf(nums, nums.length*2);
		System.out.println(Arrays.toString(tmp2));
		
		// 배열의 복사 (3) System.arraycopy(원본배열, 시작위치, 복사배열, 시작위치, 복사할 크기)
		int[] tmp3 = new int[nums.length*2];
		System.arraycopy(nums, 0, tmp3, 0, nums.length);
		System.out.println(Arrays.toString(tmp3));
	}
}
