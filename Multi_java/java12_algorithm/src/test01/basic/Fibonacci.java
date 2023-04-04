package test01.basic;
import java.util.Scanner;
public class Fibonacci {
	
	// 반복문을 이용한 피보나치 수열 구하기 (1 1 2 3 5 8 13 21 ...)
	static void forFibonacci(int n) {
		// 초기값
		int num1 = 0;
		int num2 = 1;
		int num3 = 1;
		for(int i=0; i<n; i++) {
			System.out.print(num3+" ");
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
		}
	}
	
	// 재귀호출을 이용한 피보나치 수열 구하기
	static int recursiveFibonacci(int n) {
		if(n<=1) {
			return n;
		} else {
			return recursiveFibonacci(n-2) + recursiveFibonacci(n-1); 
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		// 반복문을 이용한 피보나치 수열 구하기
		forFibonacci(n); 
		System.out.println();

		// 재귀호출을 이용한 피보나치 수열 구하기
		for(int i=1; i<=n; i++) {
			System.out.print(recursiveFibonacci(i)+" ");
			
		}
		
	}

}
