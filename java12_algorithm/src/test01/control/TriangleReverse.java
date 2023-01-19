package test01.control;

import java.util.Scanner;

public class TriangleReverse {

	public TriangleReverse() {

	}

	static void startTriangleReverse(int max) {
			for (int i=max; i>0; i-=2) {
				// 공백 출력
				for (int j=1; j<=(max-i) / 2; j++) {
					System.out.print(" ");
				}
				// 문자 출력
				for(int k=1; k<=i; k++) {
					System.out.print("*");
			}
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		startTriangleReverse(max);
	}
}
