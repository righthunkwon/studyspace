package prac1;

import java.util.Scanner;

public class Prac2_for_if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 3;
		
		for (int i = 0; i < tc; i++) {
			System.out.print("월 입력>>");
			int month = sc.nextInt();
			if (month >= 3 && month <= 5) {
				System.out.println(month + "월은 봄입니다.");
			} else if (month >= 6 && month <= 8) {
				System.out.println(month + "월은 여름입니다.");
			} else if (month >= 9 && month <= 11) {
				System.out.println(month + "월은 가을입니다.");
			} else {
				System.out.println(month + "월은 겨울입니다.");
			}
			
		}
	}

}
