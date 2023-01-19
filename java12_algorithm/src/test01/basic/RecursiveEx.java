package test01.basic;

import java.util.Scanner;

	/*
			[문제]
			두 수를 입력받아 거듭제곱을 재귀호출로 작성하라.
			(밑: base, 지수: power)
			
			[입력]
			5
			3
			
			[출력]
			125
	*/

public class RecursiveEx {

	
	static int powerRecursive(int n1, int n2) {
		// 재귀함수 종료(1로 리턴할 경우 곱하더라도 동일한 결과)
		if(n2==0) {
			return 1;
		}
		// powerRecursive : 재귀호출
		return n1 * powerRecursive(n1, n2-1); // 밑은 그대로 유지, 지수는 1 감소
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int base = scan.nextInt(); // 5
		int power = scan.nextInt(); // 3

		System.out.println(powerRecursive(base, power));
	}

}
