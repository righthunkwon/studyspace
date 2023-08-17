import java.util.Arrays;

public class Stack_12_피보나치 {
	// 피보나치 : 0과 1로 시작하고 이전의 두 수의 합을 다음 항으로 하는 수열
	public static void main(String[] args) {
		// 0 1 1 2 3 5 8 13
		System.out.println(fibo(7));
	}
	
	// 피보나치는 n을 구하기 위해 이전과 이전의 이전 값을 알고 있어야 한다.
	private static int fibo(int n) {
		// 기본부분
		// fibo(0) == 0
		// fibo(1) == 1
		// if (n == 0) return 0;
		// if (n == 1) return 1;
		
		// 한 줄에 조건 구현
		if (n <= 1) return n;
		
		// 재귀부분
		// 중복호출이 발생하므로 속도가 느린 문제점 발생(2^n만큼의 호출 발생)
		return fibo(n-1) + fibo(n-2);
	}
}
