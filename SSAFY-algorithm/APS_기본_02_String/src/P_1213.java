import java.util.Scanner;

public class P_1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		
		for (int t = 1; t <= tc; t++) {
			sc.nextInt(); // test case
			int ans = 0; // 찾은 문자열의 개수(정답)
			String pa = sc.next(); // 찾는 문자열(패턴)
			String st = sc.next(); // 검색할 문자열(전체문자열)
			
			char[] cpa = pa.toCharArray(); // 찾는 문자열의 문자 배열(패턴 문자배열)
			char[] cst = st.toCharArray(); // 검색할 문자열의 문자 배열(전체 문자배열)
			
			int n = pa.length(); // 찾는 문자열의 길이
			int m = st.length(); // 검색할 문자열의 길이

			// 0 ~ n - m 까지 시도
			for (int i = 0; i < m - n + 1; i++) {
				int cnt = 0;
				// n만큼 판단
				for (int j = 0; j < n; j++) {
					if (cpa[j] == cst[i + j]) {
						cnt++;
					} 
				}
				if (cnt == n) {
					ans++;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
