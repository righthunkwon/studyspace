package test01.control;

import java.util.Scanner;

/*
		[문제]
		3개의 정수를 입력받아 중간값을 출력하라.
		
		[입력]
		54
		75
		34
		
		[출력]
		54
	*/

public class MiddleNumber {

	public MiddleNumber() {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		if (a >= b) {
			if(b >= c) {
				System.out.println(b);
			} else if (a >= c) {
				System.out.println(c);
			} else if (c >= a ) {
				System.out.println(a);
			}
		} else if (b >= a) {
			if (a >= c) {
				System.out.println(a);
			} else if (c >= b) {
				System.out.println(b);
			} else if (b >= c) {
				System.out.println(c);
			}
		}
	}

	public static void main(String[] args) {
		new MiddleNumber();
	}

}
