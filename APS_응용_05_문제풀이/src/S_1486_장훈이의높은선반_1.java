import java.util.Scanner;

// 부분집합  & 비트마스크 활용
// n이라는 수의 부분집합의 개수는 n개의 수를 각각 포함하고 포함하지 않는 경우의 수의 합이므로 2^n개이다.
// 따라서 문제풀이 시 n개의 원소를 가진 집합의 부분집합의 총 개수를  1 << n으로 표현할 수 있다(조건문이나 반복문에서 활용 가능). 
public class S_1486_장훈이의높은선반_1 {

	// n: 점원의수 (1 ~ 20명)
	// b: 선반의 높이 (1 ~ 모든 점원의 키의 합)
	private static int n, b, ans;

	// arr: 점원들의 키 배열
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); // 점원의 수
			b = sc.nextInt(); // 선반의 높이
			arr = new int[n]; // 점원들의 키 배열

			// 배열 요소 입력
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// 정답 초기화
			// 최소값을 구할 때는 MAX_VALUE로 초기화(혹은 그냥 987654321)
			// 최대값을 구할 때는 MIN_VALUE로 초기화(혹은 그냥 0, 합이 양수인 경우)
			ans = Integer.MAX_VALUE;

			// 모든 점원의 부분집합에 대해 반복(n개의 부분집합의 개수: 2^n or 1<<n)
			for (int i = 0; i < (1 << n); i++) {
				int tmp = 0; // 중간 합

				// 부분집합(i)에 대해 어떤 점원(j)을 가졌는지 검사를 반복
				for (int j = 0; j < n; j++) {

					// 원소의 포함 여부 확인(조회) (0: 미포함, 1: 포함)
					// n & (1 << element)가 0이라면 이진수의 i번째 비트는 0이다(n: 집합, element: 요소)

					// j번째 점원이 포함되었을 경우
					if ((i & (1 << j)) != 0) {
						tmp += arr[j];
					}
				}

				// 선반의 키는 넘기면서 기존의 키의 합보다 작을 경 우 정답을 갱신
				if (tmp >= b && tmp < ans) {
					ans = tmp;
				}
			}
			System.out.printf("#%d %d\n", t, (ans - b));
		}
	}
}
