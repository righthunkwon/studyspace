import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 암호생성기
public class P_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			sc.nextInt(); // !!! !!! !!! !!! test case 입력 반드시 하자 !!! !!! !!! !!!
			Queue<Integer> queue = new LinkedList<>();

			// queue에 요소 담기
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}

			// queue를 순회하며 요소 연산
			int code = 1;
			while (code != 0) {
				for (int i = 1; i <= 5; i++) { // 사이클
					code = queue.remove();
					code -= i;
					if (code <= 0) {
						code = 0;
					}
					queue.add(code);
					if (code == 0) break;
				}
			}
			System.out.printf("#%d %s\n", t, printQueue(queue));
		}
	}

	private static String printQueue(Queue<Integer> queue) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int n = queue.remove();
			sb.append(n + " ");
		}
		return String.valueOf(sb);
	}
}

