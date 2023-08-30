import java.util.Arrays;

public class 부분집합_03 {
	private static int n = 4;
	private static boolean[] sel = new boolean[n];
	private static String[] ingredients = { "참치", "스팸", "돈까스", "제육" };

	public static void main(String[] args) {
		powerset(0);
	}

	// 특정 위치를 판단하는 메소드
	public static void powerset(int idx) {
		// 기저파트(종료조건부분)
		if (idx == n) { // 모든 재료를 전부 판단
			for (int i = 0; i < n; i++) {
				if (sel[i]) {
					System.out.print(ingredients[i] + " ");
				}
			}
			System.out.println("김밥");
			return;
		}

		// 재귀파트(반복수행부분)
		sel[idx] = false;
		powerset(idx + 1);

		sel[idx] = true;
		powerset(idx + 1);

		// 김밥 = FFFF
		// 제육김밥 = FFFT
		// 돈까스김밥 = FFTF
		// ...
		
	}

}
