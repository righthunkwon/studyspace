import java.util.Arrays;

// 방문체크를 통한 순열 생성(비트마스킹 활용)
public class 백트래킹_04_순열 {
	private static int[] nums; // 숫자 배열
	private static int[] result; // 결과 저장 배열
	private static int n; // 원소 수

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		n = nums.length;
		result = new int[n];

		perm(0, 0);
	}

	// idx = 현재 내가 판단하는 위치
	private static void perm(int idx, int visited) {
		// 기저부분(종료조건)
		if (idx == n) {
			System.out.println(Arrays.toString(result));
			return;
		}

		// 사용할 수 있는 모든 원소 확인
		for (int i = 0; i < n; i++) {
			// 방문했을 경우 넘긴다
			if ((visited & (1<<i)) > 0) continue;
			result[idx] = nums[i]; // 결과 저장
			perm(idx+1, visited | (1<<i));
		}

	}
}
