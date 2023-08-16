import java.util.Scanner;

public class P_1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			String str = sc.next();
			int ans = 1;
			for (int i = 0; i < str.length() / 2 + 1; i++) {
				// 맨앞, 맨뒤 / 맨앞+1, 맨뒤-1 / 맨앞+2, 맨뒤-2, ...
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {  
					ans = 0;
					break;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
