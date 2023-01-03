import java.util.Scanner;

public class Operator2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 삼항 연산자 : (조건식) ? (true식) : (false식)
		// 임의의 정수를 입력받아 홀수, 짝수를 구별하여 출력하라.
		// 짝수 홀수 판별법(1) : 임의의 수를 2로 나눈 나머지(0이면 짝수, 1이면 홀수)
		// 짝수 홀수 판별법(2) : / 연산자 이용
		
		/*
			실행결과
			정수입력=5
			5는 홀수입니다.
			
			실행결과
			정수입력=12
			12는 짝수입니다.
		*/
		
		// 1. 데이터
		System.out.print("정수입력=");
		int dataInt = scan.nextInt();
		
		// 2. 처리
		String result = ( dataInt%2==1 ) ? "홀수" : "짝수" ;
		
		// 3. 출력
		System.out.println(dataInt + "는 " + result + "입니다.");
		
		
		// 임의의 정수를 입력받아 양수, 음수, 0인지 구별하여 출력하라.
		// 중첩된 삼항 연산자를 활용 : (조건식) ? (양수) : ((조건식) ? (음수) : (0))
		String result2 = (dataInt>0) ? "양수" : (dataInt<0)? "음수" : "0";
		System.out.println(dataInt + "는 " + result2 + "입니다.");
		/* 
			실행결과
			정수입력=5
			5는 홀수입니다.
			5는 양수입니다.
			
			정수입력=-12
			-12는 짝수입니다.
			-12는 음수입니다.
			
			정수입력=0
			0는 짝수입니다.
			0는 0입니다.
			
		*/
	}

}
