import java.util.Scanner;

// 햄버거 다이어트
public class S_5215 {
	private static int n, limit, ans;
	private static int[] score, calorie;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			ans = 0; // test case 마다 ans 반드시 초기화!!!
			
			n = sc.nextInt(); // 재료의 수
			limit = sc.nextInt(); // 제한 칼로리

			score = new int[n]; // 재료 당 맛 점수
			calorie = new int[n]; // 재료 당 칼로리

			// 배열 요소 입력
			for (int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}

			// 재귀
			pleaseletmeknowthehighestscore(0, 0, 0);

			System.out.printf("#%d %d\n", t, ans);
		}
	}

	// 재귀는 '믿음'이다.
	private static void pleaseletmeknowthehighestscore(int idx, int s, int c) {
		// 기저부분
		if (idx == n) {
			if (c <= limit) {
				ans = Math.max(ans, s);
			}
			return;
		}

		// 재귀부분
		// (1) 재료를 미선택
		pleaseletmeknowthehighestscore(idx + 1, s, c);
		// (2) 재료를 선택
		pleaseletmeknowthehighestscore(idx + 1, s + score[idx], c + calorie[idx]); // 누적합
	}
}
