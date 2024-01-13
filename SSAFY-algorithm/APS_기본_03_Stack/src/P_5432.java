import java.util.Scanner;

// 쇠막대기 자르기
public class P_5432 {
	public static void main(String[] args) {
		// 1. (
		// 막대기 시작, 새로운 막대기 추가(cnt++)

		// 2. )
		// 막대기 끝, 막대기 개수 감소(cnt--)
		// 남은 조각 하나 증가(ans++)

		// 3. ()
		// 레이저, 막대기 자르기(ans += cnt)
		// 자를 수 있는 막대기 개수만큼 증가

		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			// 문자 배열에 입력
			String str = sc.next();
			int n = str.length();
			char[] carr = new char[n];
			for (int i = 0; i < n; i++) {
				carr[i] = str.charAt(i);
			}

			// 판단
			int cnt = 0; // 막대 개수
			int ans = 0; // 조각 개수
			for (int i = 0; i < n; i++) {
				if (carr[i] == '(' && carr[i + 1] == ')') { // 레이저('()') -> 현재 있는 막대들의 개수만큼 증가 
					ans += cnt;
					i++;
				} else if (carr[i] == '(') { // 막대 추가('(')
					cnt++; 
				} else { // 막대 끝(')') 
					cnt--;
					ans++;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
