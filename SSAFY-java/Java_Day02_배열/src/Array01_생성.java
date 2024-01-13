
public class Array01_생성 {

	public static void main(String[] args) {
		// 1차원 배열의 선언
		int[] scores1; // 권장
		int scores2[];

		// 1차원 배열의 생성
		// (1) 자료형[] 변수명 = new 자료형[길이];
		// 해당 방법은 각 자료형의 적절한 초기값이 부여된다.
		int[] scores3 = new int[5]; // int형의 초기값인 0으로 다섯 개의 값이 부여

		// 값 확인
		for (int i = 0; i < scores3.length; i++) {
			System.out.println(scores3[i]);
		}

		// (2) 자료형[] 이름 = new 자료형[] { 값1, 값2, 값3, 값4 };
		int[] scores4 = new int[] { 1, 2, 3, 4 };

		// (3) 자료형[] 이름 = { 값1, 값2, 값3, 값4 };
		// (2)와 (3)은 동일하지만 (3)에는 약간의 제약사항이 있다.
		// scores3 = new int[6]; 가능
		// scores3 = new int[] { 1, 2, 3, 4, 5 }; 가능
		// scores3 = {1, 2, 3, 4, 5}; 이건 불가능
		// 즉, 3번 방식은 선언만 가능하고 재할당은 불가능하다.
		int[] scores5 = { 1, 2, 3, 4 };
		
		

	}

}
