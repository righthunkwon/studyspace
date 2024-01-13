package array03;

public class Array03_01_BabyGin_완전탐색 {
	public static void main(String[] args) {
		int[] cards = { 3, 4, 5 };
		int n = 3;

		// 반복문을 활용한 순열 출력
		// 단, 카드는 중복되지 않는다.

		// 첫번째 카드
		for (int i = 0; i < n; i++) {
			// 두번째 카드
			for (int j = 0; j < n; j++) {
				if (i != j) {
					// 세번째 카드
					for (int k = 0; k < n; k++) {
						if (k != i && k != j) {
							System.out.printf("%d %d %d\n", cards[i], cards[j], cards[k]);
							System.out.println(runCheck(cards[i], cards[j], cards[k]));
							System.out.println(tripletCheck(cards[i], cards[j], cards[k]));
						}
					} // 3
				} // if
			} // 2
		} // 1
	}

	// run : 세 개의 숫자가 연속
	public static boolean runCheck(int a, int b, int c) {
		// 조건문을 쓰지 않더라도 true나 false를 반환할 수 있다.
		return b == a + 1 && c == a + 2;
	}
	
	// triplet : 세 개의 숫자가 동일
	public static boolean tripletCheck(int a, int b, int c) {
		return a == b  && a == c;
	}

}
