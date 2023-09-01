
// 기본적인 반복문을 활용한 순열
public class 백트래킹_01_순열 {
	public static void main(String[] args) {
		int[] cards = { 3, 4, 5 };
		int N = cards.length;

		// 반복문을 이용한 순열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					for (int k = 0; k < N; k++) {
						if (k != i && k != j) {
							System.out.printf("%d %d %d\n", cards[i], cards[j], cards[k]);
						}
					} // 3
				} // 조건문
			} // 2
		} // 1
	}
}