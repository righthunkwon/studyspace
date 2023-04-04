package test01.control;

import java.util.Scanner;

public class MiddleNumberSol {

	public MiddleNumberSol() {

	}

	static int middleCheck(int n1, int n2, int n3) {
		
		if(n1<n2 && n2<n3 || n3<n2 && n2<n1) { // n2가 중간값일 때
			return n2; 
		} else if (n2<n1 && n1<n3 || n3<n1 && n1<n2) { // n1이 중간값일 때
			return n1;
		} else if (n1<n3 && n3<n2 || n2<n3 && n3<n1) {
			return n3;
		} else { // 중간값이 없을 경우
			return -1;
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = Integer.parseInt(scan.nextLine());
		int b = Integer.parseInt(scan.nextLine());
		int c = Integer.parseInt(scan.nextLine());

		int middle = middleCheck(a, b, c);
		System.out.println(middle);
	}

}
