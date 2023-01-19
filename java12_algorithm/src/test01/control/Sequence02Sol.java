package test01.control;

import java.util.Scanner;

	/*
			[입력]
			9
				
			[출력]
					*
				   **
				  ***
				 ****
				*****
			   ******
			  *******
			 ********
			*********
	*/

public class Sequence02Sol {

	public Sequence02Sol() {
	}
	
	static void star(int max) {
		for(int row=1; row<=max; row++) { // 출력할 문자의 갯수
			// 공백
			for(int s=1; s<=max-row; s++) {
				System.out.print(" ");
			}
			// 문자출력
			for(int i=1; i<=row; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		star(max); // static을 써줄 경우 객체로 만들지 않고도 바로 호출할 수 있다.
	}

}
