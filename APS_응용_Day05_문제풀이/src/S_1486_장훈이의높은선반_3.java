import java.util.Scanner;

// 부분집합  & 재귀함수(중간합 저장방식) 활용
// n이라는 수의 부분집합의 개수는 n개의 수를 각각 포함하고 포함하지 않는 경우의 수의 합이므로 2^n개이다.
// 따라서 문제풀이 시 n개의 원소를 가진 집합의 부분집합의 총 개수를  1 << n으로 표현할 수 있다(조건문이나 반복문에서 활용 가능). 
public class S_1486_장훈이의높은선반_3 {

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
			powerset(0, 0);
			System.out.printf("#%d %d\n", t, (ans - b));
		}
	}

	private static void powerset(int idx, int tmp) {
		// 결과 가지치기(정원사)
		if (tmp > ans) {
			return;
		}
		
		// 기저부분(종료조건)
		if (idx == n) {
			// 만약 키의 합이 선반의 높이를 넘을 경우, 기존 정답과 이를 비교하여 최솟값을 정답에 갱신한다.
			if (tmp >= b) {
				ans = Math.min(ans, tmp);
			}
			return;
		}
		
		// 재귀부분(반복수행)
		powerset(idx + 1, tmp + arr[idx]); // 쌓고 넘어가고
		powerset(idx + 1, tmp); // 안 쌓고 넘어가고
	}
}
