import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 사칙연산
public class P_1232 {
	static char[] op; // 연산자 배열
	static int[] num; // 숫자 배열
	static int[][] tree; // 이진트리 배열

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			op = new char[n + 1];
			num = new int[n + 1];
			tree = new int[n + 1][2];
			sc.nextLine();
			for (int i = 1; i <= n; i++) {
				String[] s = sc.nextLine().split(" ");
				if (s[1].equals("-") || s[1].equals("+") || s[1].equals("*") || s[1].equals("/")) {
					op[i] = s[1].charAt(0);
					tree[i][0] = Integer.parseInt(s[2]);
					tree[i][1] = Integer.parseInt(s[3]);
				} else
					num[i] = Integer.parseInt(s[1]);

			}
			System.out.print("#" + t + " " + Tree(1) + "\n");
		}
	}

	private static int Tree(int c) {
		if (num[c] != 0)
			return num[c];
		if (op[c] == '+')
			return Tree(tree[c][0]) + Tree(tree[c][1]);
		else if (op[c] == '-')
			return Tree(tree[c][0]) - Tree(tree[c][1]);
		else if (op[c] == '*')
			return Tree(tree[c][0]) * Tree(tree[c][1]);
		else
			return Tree(tree[c][0]) / Tree(tree[c][1]);
	}
}