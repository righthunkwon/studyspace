import java.util.Scanner;
import java.util.Stack;

// 제로
public class P_8931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int k = sc.nextInt();
			int[] arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}

			Stack<Integer> stack = new Stack<>();
			int ans = 0;
			for (int i = 0; i < k; i++) {
				if (arr[i] == 0) {
					ans -= stack.pop();
				} else {
					ans += stack.push(arr[i]);
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}

	}
}
