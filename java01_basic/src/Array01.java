
public class Array01 {

	public static void main(String[] args) {
		// 배열 : 같은 데이터형의 변수가 여러 개 필요할 때 선언하여 사용
		// 배열의 선언 : 데이터형 옆에도, 변수 옆에도 가능하다. (int[] score;   , int score[];)
		// 배열의 선언 예시 : int a[] = new int[5];
		// stack 영역과 heap 영역의 개념(노션 참고)
		// Java는 한 번 생성한 배열의 크기를 변경할 수 없다. 
		
		/*
		 	초기값
		  	정수 : 0
		  	실수 : 0.0
		  	논리 : false
		  	그외 : null
		 */ 
		 
		
		// 1차원 배열
		// 기본 배열(초기값: 0)
		int score1[];
		int[] score2;
		
		// 정수값을 다섯 개 저장할 수 있는 배열형
		int[] data = new int[5];
		String name[] = new String[5];
		
		// index는 0부터 시작한다.
		name[1] = "홍길동";
		data[2] = 90;
		
		
		// 배열명.length : 배열의 길이
		for(int i=0; i<data.length; i++) {
			System.out.println("score3["+i+"]="+ data[i]);
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.println("name["+i+"]="+ name[i]);
		}
	}

}
