package test01.control;

import java.util.Scanner;

public class NumberReverse {

	public NumberReverse() {
		
	}
	
	static void numberReverse() {
		// 정수형을 역순으로 처리한다. (123456 -> 654321)
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int reverse = 0;
		int last = 0;
		
		while(num != 0) {
			last = num % 10;
			reverse = reverse * 10 + last;
			num = num / 10;
		}
		System.out.println(reverse);
	}
	
	public static void main(String[] args) {
		NumberReverse nr = new NumberReverse();
		nr.numberReverse();
	}

}
