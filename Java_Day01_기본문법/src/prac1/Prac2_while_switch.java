package prac1;

import java.util.Scanner;

public class Prac2_while_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int tc = 0;

		while (run) {
			System.out.print("월 입력>>");
			int month = sc.nextInt();
			switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.println(month + "월은 봄입니다.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(month + "월은 여름입니다.");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println(month + "월은 가을입니다.");
				break;
			default:
				System.out.println(month + "월은 겨울입니다.");
				break;
			}
			tc++;
			if (tc == 3) {
				run = false;
			}
		}

	}
}
