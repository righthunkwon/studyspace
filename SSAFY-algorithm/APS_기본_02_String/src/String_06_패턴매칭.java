
public class String_06_패턴매칭 {
	public static void main(String[] args) {
		// 브루트 포스
		// 해당 패턴이 본문 안에 들어있는지
		// 들어있다면 몇 번째 인덱스부터 시작하는지
		String st = "This iss a book"; // 길이: 15
		String pa = "iss"; // 길이: 3
		System.out.println(bruteForceFor(st, pa)); // 5
		System.out.println(bruteForceWhile(st, pa)); // 5

	}

	public static int bruteForceFor(String st, String pa) {
		int n = st.length();
		int m = pa.length();

		// 0 ~ n - m 까지 시도
		int cnt = 0;
		for (int i = 0; i < n - m + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < m; j++) {
				if (pa.charAt(j) != st.charAt(i + j)) {
					flag = false;
					break;
				}
			} // 패턴 매칭 수행(j)
			if (flag) {
				return i;
			}
		} // 패턴 매칭 시작점 위치(i)
		return -1; // 찾지 못했을 경우
	}
	
	public static int bruteForceWhile(String st, String pa) {
		int n = st.length();
		int m = pa.length();
		
		int i = 0; // 본문의 인덱스
		int j = 0; // 패턴의 인덱스
		
		while (j < m && i < n) {
			if (st.charAt(i) != pa.charAt(j)) {
				i -= j;
				j = -1;
			}
			i++;
			j++;
		}
		if (j == m) {
			return i - m;
		}
		return -1;
	}
}
