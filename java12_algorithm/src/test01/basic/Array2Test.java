package test01.basic;

public class Array2Test {

	public Array2Test() {

	}

	public static void main(String[] args) {
		// 2차원 배열 : 행과 열이 있는 표 형식으로 데이터를 관리

		// 2차원 배열 생성
		int arr1[][]; // 배열 생성 이전
		int arr2[][] = new int[7][3]; // 배열 생성, 7행 3열(단, 0행 0열부터 시작), 초기값 : 0 (정수=0, 실수=0.0, Object=null)
		Object[][] obj = new Object[2][3]; // 배열 생성, 2행 3열(단, 0행 0열부터 시작), 초기값 : null

		// 2차원 배열에 값 넣기(arr2)
		arr2[0][1] = 100; // 1행 2열에 100을 넣는다.
		arr2[4][2] = 200; // 5행 3열에 200를 넣는다.

		// arr2: 2차원 배열 표 형식으로 출력하기(행렬)(arr2)
		for (int row = 0; row < arr2.length; row++) { // 행: 0,1,2,3,4,5,6
			for (int col = 0; col < arr2[row].length; col++) { // 열: 0,1,2
				System.out.print(arr2[row][col] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("====================");
		
		// 2차원 배열 초기값 설정
		int[][] arr3 = 
			{ 
					{ 1, 2, 3 }, 
					{ 10, 20, 30 }, 
					{ 100, 200, 300 }
			};;

		for(
		int i = 0;i<arr3.length;i++)
		{
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}

}

	/*
			배열의 길이 구하기 
					1차원 배열	 : 배열명.length -> 배열의 크기 
					2차원 배열	 : 배열명.length -> 행의 수 
							 : 배열명[행index].length -> 행index의 칸 수 -> 열의 수
			
			행의 수와 열의 수는 실제 우리가 세는 수(1부터 시작)와 index에서 처리하는 수(0부터 시작)가 다르므로 주의하여 생각하여야 한다!
	*/
