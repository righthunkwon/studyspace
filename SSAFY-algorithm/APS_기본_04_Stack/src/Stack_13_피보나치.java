import java.util.Arrays;

public class Stack_13_피보나치 {
	private static int[] cnt = new int[50]; // 호출 횟수 확인

	// 피보나치 : 0과 1로 시작하고 이전의 두 수의 합을 다음 항으로 하는 수열
	public static void main(String[] args) {
		System.out.println(fibo(45)); // 컴퓨터가 아야하는 호출
		System.out.println(Arrays.toString(cnt));
	}

	private static int fibo(int n) {
		// 호출 횟수 확인
		cnt[n]++;

		// 기본부분
		if (n <= 1)
			return n;

		// 재귀부분
		// 중복호출이 발생하므로 속도가 느린 문제점 발생(2^n만큼의 호출 발생)
		return fibo(n - 1) + fibo(n - 2);
	}
}
