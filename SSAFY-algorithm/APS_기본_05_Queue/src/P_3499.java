import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 퍼펙트 셔플
public class P_3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			Queue<String> upperqueue = new LinkedList<>();
			Queue<String> lowerqueue = new LinkedList<>();
			Queue<String> resultqueue = new LinkedList<>();
			StringBuilder result = new StringBuilder();

			int n = sc.nextInt();
			String[] str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = sc.next();
				if (n % 2 == 0) { // 카드 개수가 짝수일 때
					if (i < n/2) { // 홀수번째 카드일 때(짝수번째 index)
						upperqueue.add(str[i]);
					} else { // 짝수번째 카드일 때(홀수번째 index)
						lowerqueue.add(str[i]);
					}
				} else { // 카드 개수가 홀수일 때
					if (i <= n/2) { // 홀수번째 카드일 때(짝수번째 index)
						upperqueue.add(str[i]);
					} else { // 짝수번째 카드일 때(홀수번째 index)
						lowerqueue.add(str[i]);
					}
				}
			}
			
			for (int i = 0; i <= n / 2; i++) {
				resultqueue.add(upperqueue.poll()); // 하나가 더 들어갈 수 있어요 :)
				if (!lowerqueue.isEmpty()) resultqueue.add(lowerqueue.poll());
			}
			
			for (int i = 0; i < n; i++) {
				result.append(resultqueue.poll() + " ");
			}
			System.out.printf("#%d %s\n", t, result);
		}
	}
}

