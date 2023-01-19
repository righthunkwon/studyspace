package test01.control;

import java.util.Scanner;

/*
			[입력]
			n = 5
			
			[출력]
			  * 
		     *** 
			***** 
		   ******* 
	      ********* 
	     
	     	[풀이 팁]
	     	공백은 왼쪽만 고려해도 풀 수 있다.
	*/

public class Triangle {

	public Triangle() {
		
	}

	static void startTriangle(int max) {
		for(int i=1; i<=max; i+=2) {
			// 공백 출력 (max-i)/2
			for(int j=1; j<=(max-i)/2; j++) {
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
		startTriangle(max);
	}

}
