package test01.basic;

	/*
		[배열]
		1	2	3	4	0
		5	6	7	8	0
		9	10	11	12	0
		0	0	0	0	0
		
		
		[실행 결과] (마지막 행렬에 합 나타내기)
		1	2	3	4	10
		5	6	7	8	20
		9	10	11	12	42
		15	18	21	24	0
	*/

public class Array2Ex03 {

	public static void main(String[] args) {
		int [][] arr = {
				{1,2,3,4,0},
				{5,6,7,8,0},
				{9,10,11,12,0},
				{0,0,0,0,0}
		};
		
		// 계산
		for(int r=0; r<arr.length-1; r++) { // 행 0,1,2
			for(int c=0; c<arr[r].length-1; c++) { // 열 0,1,2,3
				// 누적(행의 합 & 열의 합)
				arr[r][arr[r].length-1] += arr[r][c]; // 행의 합
				arr[arr.length-1][c] += arr[r][c]; // 열의 합
			}
		}
		
		// 출력
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[r].length; c++) {
				System.out.printf("%5d", arr[r][c]);
			}
			System.out.println();
		}
	}

}
