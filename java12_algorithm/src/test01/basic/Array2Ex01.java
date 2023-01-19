package test01.basic;

import java.util.Scanner;

/*
		초기값 배열			행 우선 탐색
		1	2	3	4    	1	2	3	4    		
		5	6	7	8		5	6	7	8
		9	10	11	12		9	10	11	12
		13	14	15	16		13	14	15	16	
		
		열 우선 탐색			지그재그 탐색
		1	5	9	13		1	2	3	4
		2	6	10	14		8	7	6	5
		3	7	11	15		9	10	11	12	
		4	8	12	16		16	15	14	13
	*/

public class Array2Ex01 {
	static int arr[][];
	static int row;
	static int col;

	public Array2Ex01() {
		
	}
	
	static void setData() {
		arr = new int[row][col];
		int value = 1; // 초기값
		
		for(int i=0; i<row; i++) { // 행 번호
			for(int j=0; j<col; j++) { // 열 번호
				arr[i][j] = value++;
			}
		}
	}
	
	// 행 우선 탐색
	static void searchByRow() {
		for(int r=0; r<row; r++) { // 행 index
			for(int c=0; c<col; c++) { // 열 index
				System.out.print(arr[r][c]+"\t");
			}
			System.out.println();
		}
	}
	
	// 열 우선 탐색
	static void searchByCol() {
		for(int c=0; c<col; c++) { // 열 index
			for(int r=0; r<row; r++) { // 행 index
				System.out.print(arr[r][c]+"\t");
			}
			System.out.println();
		}
	}
	
	// 지그재그 탐색
	static void searchByZigzag() {
		for(int r=0; r<row; r++) { // 행 index
			if(r%2==0) { // 행 번호가 짝수일 때(역순으로 출력)
				for(int c=0; c<col; c++) { // 열 index
					System.out.print(arr[r][c]+"\t");
				}
			} else { // 행 번호가 홀수일 때
				for(int c=col-1; c>=0; c--) {
					System.out.print(arr[r][c]+"\t");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		row = scan.nextInt(); // 행의 수
		col = scan.nextInt(); // 열의 수
		// 초기값
		setData();
		
		System.out.println("** 행 우선 탐색**");
		searchByRow();
		
		System.out.println("** 열 우선 탐색**");
		searchByCol();

		System.out.println("** 지그재그 탐색**");
		searchByZigzag();
	}

}
