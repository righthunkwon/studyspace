package test01.control;

import java.util.Scanner;

public class DiamondABC {

	// 정수 입력
	static int dataIn() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수입력(1~49)=");
		int max = scan.nextInt();
		if(max%2==0) {
			max++;
		}
		return max;
	}
	
	// 다이아몬드 출력
	static void diamondPrint(int max) {
		int step = 2;
		char c = 'A';
		for(int i=1; i>=1; i+=step) { // i=1,3,5, ... max 
			// 공백 출력
			for(int j=1; j<=(max-i)/2; j++) {
				System.out.print(" ");
			}
			// 문자 출력
			for(int k=1; k<=i; k++) {
				System.out.print(c++); // 출력 후 다음 문자 생성
				if(c>'Z') {
					c = 'A';
				}
			}
			System.out.println();
			if(i==max) { // // i=(max),... , 5, 3, 1
				step = -2;
			}
		}
	}
	
	public static void main(String[] args) {
		diamondPrint(dataIn());
	}

}
