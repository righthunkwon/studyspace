import java.util.Arrays;
import java.util.Scanner;

// 규영이와 인영이의 카드게임
// 다시 구현하기
public class S_6808 {
	private static int[] cardG, cardI;
	private static int n, ans, total, winG, winI;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			total = 362880;
			n = 9;
			winG = 0; // 규영 승
			winI = 0; // 인영 승
			cardG = new int[n]; // 규영 카드(고정)
			cardI = new int[n]; // 인영 카드(9!)
			
			
			
			System.out.printf("#%d %d\n", t, ans);
		}

	}
	
	private static void perm(int idx) {
		// 기저부분(종료조건)
		if (idx == n) {
			return;
		}
		
		// 재귀조건(반복수행)
		for (int i = idx; i < n; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
		
	}
	
	private static void swap(int a, int b) {
		int tmp = cardI[a];
		cardI[a] = cardI[b];
		cardI[b] = tmp;
	}
}
