import java.util.Arrays;

public class 조합_01 {

	private static String[] topping = { "치즈", "감자", "새우", "베이컨", "양파" };
	private static int n = 5; // 배열 길이
	private static int r = 2; // 판단 부분
	private static String[] sel = new String[r];

	public static void main(String[] args) {
		combination(0, 0);
	}

	// idx: 토핑의 시작 인덱스
	// sidx: sel의 인덱스
	public static void combination(int idx, int sidx) {
		// 기저파트
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 재귀파트
		for (int i = idx; i <= n-r+sidx; i++) {
			sel[sidx] = topping[i];
			combination(i+1, sidx+1);
		}
	}
}
