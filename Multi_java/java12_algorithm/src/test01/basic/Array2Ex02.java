package test01.basic;

import java.util.Scanner;

public class Array2Ex02 {

	public Array2Ex02() {
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt(); // 행의 수
		int col = scan.nextInt(); // 열의 수
		int arr[][] = new int[row][col];
		
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) { // c<col -> ,c<arr[r].length로도 변경 가능하다(칸수 = 열수)
				if(r==c || r+c==arr.length-1) {
					System.out.print("X\t");
				} else {
					System.out.print("O\t");
				}
			} 
			System.out.println();
		}
		
	}

}
