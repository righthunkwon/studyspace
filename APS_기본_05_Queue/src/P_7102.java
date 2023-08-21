import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 준홍이의 카드놀이
public class P_7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n + m + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					arr[i + j]++;
				}
			}
			int max = 0;
			for (int i = 2; i <= m + n; i++) {
				max = Math.max(arr[i], max);
			}
			System.out.print("#" + t + " ");
			for (int i = 2; i <= m + n; i++) {
				if (arr[i] == max)
					System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
