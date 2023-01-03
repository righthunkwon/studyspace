// 사용할 클래스가 있는 위치와 클래스 명, 클래스가 있는 곳을 알려줘야 한다.
import java.lang.String; // java.lang : 기본 패키지, 생략 가능
import java.util.Scanner; // java.util : 기본 패키지가 아니라 명시해주어야 한다.

public class ScannerTest {

	public static void main(String[] args) {
		// Scanner : 실행 중 콘솔에서 정수, 실수, 논리, 문자열 데이터를 입력받는 기능
		// 클래스를 사용하기 위한 방법
		
		// 1. 객체 : 클래스로 new라는 키워드를 이용하여 만든다.
		// Scanner : 클래스
		// String : 클래스
		// 변수도 클래스도 선언할 수 있다.
		
		// 객체명.메소드명
		/*
			메소드의 종류
				정수 : nextByte(), nextShort(), nextInt(), nextLong()
				실수 : nextFloat(), nextDouble()
				논리 : nextBoolean()
				문자열 : nextLine()
		*/
		
		
		// instance 변수, reference 변수
		Scanner scan = new Scanner(System.in);
		
		
		// 프로그램 실행 중 값을 입력받기
		// 1. 정수의 메소드 

		// System.out.print(); 줄바꿈 X
		// System.out.println(); 줄바꿈 O
		
		System.out.print("숫자입력=");
		int num1 = scan.nextInt();
		System.out.println("num1+10 = " + (num1 + 10));
		
	
		// 2. 실수의 메소드
		System.out.print("숫자입력=");
		double num2 = scan.nextDouble();
		System.out.println("num2+10.2 = " + (num2 + 10.2));
	}
}
