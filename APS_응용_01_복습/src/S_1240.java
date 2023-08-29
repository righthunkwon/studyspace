import java.util.Arrays;
import java.util.Scanner;

// 단순 2진 암호코드
public class S_1240 {

	// 모든 암호키는 1로 끝난다는 공통점 존재
	private static String zero = "0001101";
	private static String one = "0011001";
	private static String two = "0010011";
	private static String three = "0111101";
	private static String four = "0100011";
	private static String five = "0110001";
	private static String six = "0101111";
	private static String seven = "0111011";
	private static String eight = "0110111";
	private static String nine = "0001011";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			int n = sc.nextInt(); // 세로크기(행)
			int m = sc.nextInt(); // 가로크기(열)
			int[][] arr = new int[n][m]; // 암호 배열

			int r = 0; // 행
			int c = 0; // 열

			// 배열 요소 입력
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			// 1로 시작하는 요소를 찾은 뒤 해당 요소의 열과 행을 저장
			outer: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1) {
						r = i;
						c = j;
						break outer;
					}
				}
			}

			// 처음 1이 나온 행과 열을 기준으로 해당 열에서 (56-1)열을 더한 곳을 시작으로 역방향으로 순회하며
			// 처음으로 1이 오는 열의 인덱스를 탐색한다. 이후 'c -= c + 56 - 1 - last'를
			// 계산하면 암호 코드의 시작 열 인덱스를 찾을 수 있다.
			int last = 0;
			for (int j = c + 56 - 1; j >= c; j--) {
				if (arr[r][j] == 1) {
					last = j;
					c -= c + 56 - 1 - last; // 암호문을 시작하는 처음 열의 인덱스
					break;
				}
			}

			// 암호덩어리(길이: 56)를 스트링빌더에 담는다.
			StringBuilder sb = new StringBuilder();
			for (int j = c; j < c + 56; j++) {
				sb.append(arr[r][j]);
			}
			String codemass = String.valueOf(sb);
			int[] code = new int[8]; // 암호

			// 인덱스
			int idx = 0;
			int st = 0;
			int ed = 7;
			int cnt = 1;

			// wow...
			while (cnt <= 8) {
				if ((codemass.substring(st, ed)).equals(zero)) {
					code[idx] = 0;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(one)) {
					code[idx] = 1;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(two)) {
					code[idx] = 2;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(three)) {
					code[idx] = 3;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(four)) {
					code[idx] = 4;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(five)) {
					code[idx] = 5;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(six)) {
					code[idx] = 6;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(seven)) {
					code[idx] = 7;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(eight)) {
					code[idx] = 8;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				} else if ((codemass.substring(st, ed)).equals(nine)) {
					code[idx] = 9;
					st += 7;
					ed += 7;
					idx++;
					cnt++;
				}
			}

			int checknum = 0; // 암호 검증 변수
			int sum = 0; // 코드 총합
			for (int i = 0; i < code.length; i++) {
				if (i % 2 == 0) {
					checknum += code[i] * 3;
					sum += code[i];
				} else {
					checknum += code[i];
					sum += code[i];
				}
			}

			if (checknum % 10 == 0) {
				System.out.printf("#%d %d\n", t, sum);
			} else {
				System.out.printf("#%d %d\n", t, 0);
			}
		}
	}
}
