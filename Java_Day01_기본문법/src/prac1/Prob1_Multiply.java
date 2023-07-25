package src.prac1;

import java.util.Scanner;

public class Prob1_Multiply {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 :");
		int num = sc.nextInt();
		boolean run = true;
		while (run) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(num + " * " + i + " = " + num * i);
			}
			System.out.print("다음 숫자 입력 :");
			num = sc.nextInt();
			if (num == 0) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
	}
}
