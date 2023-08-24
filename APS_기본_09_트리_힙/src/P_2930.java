import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class P_2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			int n = sc.nextInt(); // 연산의 수
			for (int i = 0; i < n; i++) {
				if (sc.nextInt() == 1) {
					pq.add(sc.nextInt());
				} else {
					if (pq.isEmpty()) {
						sb.append("-1 ");
						continue;
					}
					sb.append(pq.poll() + " ");
				}
			}
			System.out.printf("#%d %s\n", t, sb);
		}
	}

}
