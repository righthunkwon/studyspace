import java.util.Arrays;

// 원본을 수정하는 순열 생성
public class 백트래킹_02_순열 {
	private static int[] nums; // 배열
	private static int n; // 원소 수

	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		n = nums.length;
		
		perm(0);
	}
	
	// idx = 현재 내가 판단하는 위치
	private static void perm(int idx) {
		// 기저부분(종료조건)
		if (idx == n) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		// 재귀조건(반복수행)
		for (int i = idx; i < n; i++) {
			swap(i, idx); // 바꾸고
			perm(idx+1); // 순열하고
			swap(i, idx); // 되돌리고
		}
		
	}
	
	private static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
