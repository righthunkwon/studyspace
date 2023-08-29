import java.util.Scanner;

// 이진수 표현
public class S_10726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 마지막 n개의 비트 
			int m = sc.nextInt(); // 주어진 정수
			String ans = "OFF"; // 정답
			for (int i = 0; i < n; i++) {
				if (m % 2 == 1) {
					m /= 2;
					ans = "ON";
				} else {
					ans = "OFF";
				}
			}
			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
