
import java.util.Scanner;

// 규영이와 인영이의 카드게임
public class S_6808 {
	private static int wincnt;
	private static int losecnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			// test case마다 정답 초기화
			wincnt = 0;
			losecnt = 0;

			// 규영이의 카드 배열
			int[] cards = new int[9];

			// 전체 카드 배열(true: 이미 내서 못 냄, false: 아직 낼 수 있음)
			// 1부터 18까지의 수이므로 인덱스 0은 버린다.
			boolean[] check = new boolean[19];

			// 규영 카드 배열요소 입력
			// 규영이의 카드는 고정값으로 낼 수 없으므로 true로 처리
			for (int i = 0; i < 9; i++) {
				cards[i] = sc.nextInt();
				check[cards[i]] = true;
			}

			// 구현 및 정답 출력
			// 재귀함수는 규영이를 기준으로 규영이가 이긴 건 win, 규영이가 진 건 lose로 표현
			// recursion(규영이가 얻은 점수, 인영이가 얻은 점수, 재귀의 깊이(판 수), 배열, 전체 카드 배열(남은 카드 수 판단))
			recursion(0, 0, 0, cards, check);
			System.out.printf("#%d %d %d\n", t, wincnt, losecnt);
		}
	}

	public static void recursion(int win, int lose, int depth, int[] cards, boolean[] check) {
		// 기저부분(종료조건)
		if (depth == 9) {
			if (win > lose) {
				wincnt++;
			} else {
				losecnt++;
			}
		}

		// 재귀부분(반복수행)
		// 1 ~ 18번의 카드 중 낼 수 있는 카드면 내고 이를 true로 처리하고, 재귀 종료 후 이를 false로 되돌린다.
		for (int i = 1; i <= 18; i++) {
			if (!check[i]) {
				// i번째 카드를 낸다.
				check[i] = true;
				if (cards[depth] > i) {
					// 규영이의 카드가 더 크면 두 카드의 합만큼 규영이의 점수를 높인다.
					recursion(win + i + cards[depth], lose, depth + 1, cards, check); 
				} else {
					// 인영이의 카드가 더 크면 두 카드의 합만큼 인영이의 점수를 높인다
					recursion(win, lose + i + cards[depth], depth + 1, cards, check); 
				}
				// i번째 카드를 회수한다.
				check[i] = false; 
			}
		}
	}
}
