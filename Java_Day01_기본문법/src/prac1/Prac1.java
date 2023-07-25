package src.prac1;

import java.util.Scanner;

public class Prac1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 >>");
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		
		System.out.println("1부터 10까지 수 중 짝수의 합 = " + sum);
		
	}

}
