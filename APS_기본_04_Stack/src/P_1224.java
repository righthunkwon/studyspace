import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 계산기 1
public class P_1224 {
	public static void main(String[] args) {
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0); // 스택 내부 괄호

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				sc.next().charAt(i);
			}
		}

	}
}
