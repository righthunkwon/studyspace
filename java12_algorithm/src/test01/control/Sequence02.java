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

public class Sequence02 {

	public Sequence02() {
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int starNum = scan.nextInt();
		
		for(int i=1; i<=starNum; i++) {
			for(int j=starNum; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
