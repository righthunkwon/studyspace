import java.util.Arrays;

public class 조합_02 {

	private static String[] topping = { "치즈", "감자", "새우", "베이컨", "양파" };
	private static int n = 5; // 배열 길이
	private static int r = 2; // 판단 부분(뽑는 횟수)
	private static String[] sel = new String[r];

	public static void main(String[] args) {
		combination(0, 0);
	}

	// idx: 토핑의 인덱스
	// sidx: sel의 인덱스
	public static void combination(int idx, int sidx) {
		// 기저파트
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx == n) {
			return;
		}
		
		// 재귀파트
		sel[sidx] = topping[idx]; // 재료를 넣는다
		combination(idx+1, sidx+1); // idx 번째 재료를 뽑은 경우
		combination(idx+1, sidx); // idx 번째 재료를 뽑지 않은 경우
	}
}
