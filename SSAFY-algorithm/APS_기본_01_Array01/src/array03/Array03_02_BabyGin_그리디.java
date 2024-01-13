package array03;

public class Array03_02_BabyGin_그리디 {
	public static void main(String[] args) {
		int[] cards = { 3, 4, 5, 4, 4, 4 };
		int[] cnt = new int[12]; // 배열 범위 초과 방지 10 + 2

		// 도수분포표 배열
		for (int i = 0; i < cards.length; i++) {
			cnt[cards[i]]++;
		}
		int i = 0;
		while (i < 10) {
			// triplet 검사
			if (cnt[i] >= 3) {
				cnt[i] -= 3;
				System.out.println("triplet!!!");
				continue;
			}
			// run 검사
			if (cnt[i] >= 1 && cnt[i + 1] >= 1 && cnt[i + 2] >= 1) {
				cnt[i]--;
				cnt[i - 1]--;
				cnt[i - 2]--;
				System.out.println("run!!!");
				continue;
			}
			i++;
		}
	}
}
