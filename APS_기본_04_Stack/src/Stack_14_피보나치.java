import java.util.Arrays;

public class Stack_14_피보나치 {
	public static void main(String[] args) {
		System.out.println(memofibo(45)); // 컴퓨터가 편안한 호출
	}

	// 기록하여 효율 개선하기
	// memo[0] memo[1]을 각각 0과 1로 초기화
	private static int[] memo = new int[50];
	static {
		memo[0] = 0;
		memo[1] = 1;
	}

	private static int memofibo(int n) {
		if (n>= 2 && memo[n] == 0) {
			memo[n] = memofibo(n-1) + memofibo(n-2);
		}
		return memo[n];
	}
}
