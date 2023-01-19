package test01.basic;

public class Array2Ex04 {


	public static void main(String[] args) {
		
		String[] nameList = {"블랙핑크", "방탄소년단", "뉴진스", "엑소", "스트라이크", "트와이스", "르세라핌", "세븐틴", "에스파", "아이브", "과목별총점", "과목별평균"}; 
		
		int [][] arr = {
				{85,92,25,0,0,0},
				{90,99,92,0,0,0},
				{70,69,34,0,0,0},
				{92,84,85,0,0,0},
				{62,68,98,0,0,0},
				{64,86,92,0,0,0},
				{85,53,72,0,0,0},
				{87,65,96,0,0,0},
				{95,45,49,0,0,0},
				{65,94,58,0,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0}
		};
		
		
		// 총점 계산 (석차 미구현)
		
		for(int r=0; r<arr.length-2; r++) { // 행
			for(int c=0; c<arr[r].length-3; c++) { // 열
				// 누적(행의 합 & 열의 합)
				arr[arr.length-2][c] += arr[r][c]; // 과목별 총점
				arr[r][arr[r].length-3] += arr[r][c]; // 개인 총점
				if(r==arr.length-3) {
					arr[arr.length-1][c] = arr[arr.length-2][c]/10; // 과목별 평균
				}
				if(c==arr[r].length-4) {
					arr[r][arr[r].length-2] = arr[r][arr[r].length-3]/3; // 개인 평균
				}
			} 
		}
		
		// 출력
		for(int r=0; r<arr.length; r++) {
			System.out.print(nameList[r]+"\t\t");
			for(int c=0; c<arr[r].length; c++) {
				System.out.print(arr[r][c]+"\t");
			}
			System.out.println();
			
		}
		
	}

}
