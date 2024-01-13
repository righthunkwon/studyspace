import java.util.Arrays;

// 방문체크를 통한 순열 생성
public class 백트래킹_03_순열 {
	private static int[] nums; // 숫자 배열
	private static int[] result; // 결과 저장 배열
	public static boolean[] visited; // 방문여부
	private static int n; // 원소 수

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		n = nums.length;
		result = new int[n];
		visited = new boolean[n];

		perm(0);
	}

	// idx = 현재 내가 판단하는 위치
	private static void perm(int idx) {
		// 기저부분(종료조건)
		if (idx == n) {
			System.out.println(Arrays.toString(result));
			return;
		}

		// 사용할 수 있는 모든 원소 확인
		for (int i = 0; i < n; i++) {
			// 방문하지 않았을 때만 실행(백트래킹)
			if (!visited[i]) { 
				result[idx] = nums[i]; // i번째 원소 저장
				visited[i] = true; // i번째 사용했다고 표시
				perm(idx + 1); // 1 depth 내려감
				visited[i] = false; // i번째 사용 여부를 되돌림
			}
		}
	}
}
