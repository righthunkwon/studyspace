package test01.control;

import java.util.Scanner;

	/*
		[입력]
		9
		
		[출력]
	 	*********
		********
		*******
		******
		*****
		****
		***
		**
		*
	*/

public class Sequence03 {

	public Sequence03() {
	
	}
	
	static void star(int max) {
		for(int i=max; i>=1; i--) { // 출력할 문자의 갯수
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		star(max);
	}
}
