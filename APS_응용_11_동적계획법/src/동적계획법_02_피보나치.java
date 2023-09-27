import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_02_피보나치 {
	static int callFibo1, callFibo2;
	static int[] memo;
	
	static {
		memo = new int[1000];
		memo[0] = 0;
		memo[1] = 1;
		//여기서 미리 전부 계산을 해두겠다.
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		memo[0] = 0; //이거 사실 필요한가?
		memo[1] = 1;
//		System.out.println(fibo(N));
//		System.out.println(callFibo1);
		System.out.println("----------------------");
		System.out.println(fibo2(N));
		System.out.println(callFibo2);
		
		System.out.println(fibo3(N));
		
	}// main
	
	public static long fibo3(int n) {
		long[] dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		return dp[n];
	}
	
	public static int fibo2(int n) {
		callFibo2++;
		
		if(memo[n] == -1) {
//		if(n>=2 && memo[n] == 0) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	
	
	
	public static int fibo(int n) {
		callFibo1++;
		// 기저조건
//		if(n == 0) return 0;
//		if(n == 1) return 1;
//		if(n <= 1) return n;
		if (n < 2)
			return n;
		return fibo(n - 1) + fibo(n - 2);

		// 재귀조건
	}

}
