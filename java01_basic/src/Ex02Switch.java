import java.util.Scanner;

public class Ex02Switch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		[처리조건]
		콘솔에서 국어, 영어, 수학점수를 입력받아 다음과 같이 출력하라.
		(단, 평균은 실수로 구하고 학점은 switch 문을 이용하여 구하라.)
		
		[실행결과]
		국어점수=__
		영어점수=__
		수학점수=__
		총점=__
		평균=__
		학점=__
		*/ 
		
		// 
		
		System.out.print("국어점수=");
		double korScore = scan.nextInt();
		
		System.out.print("영어점수=");
		double engScore = scan.nextInt();
		
		System.out.print("수학점수=");
		double mathScore = scan.nextInt();
		
		System.out.println("총점=" + (korScore + engScore + mathScore));
		System.out.println("평균=" + (korScore + engScore + mathScore)/3);
		int averageScore = (int)(korScore + engScore + mathScore)/30;
		
		switch (averageScore) {
		case 1: 
			System.out.println("학점=F");
			break;
		case 2: 
			System.out.println("학점=F");
			break;
		case 3: 
			System.out.println("학점=F");
			break;
		case 4: 
			System.out.println("학점=F");
			break;
		case 5: 
			System.out.println("학점=F");
			break;
		case 6: 
			System.out.println("학점=D");
			break;
		case 7: 
			System.out.println("학점=C");
			break;
		case 8: 
			System.out.println("학점=B");
			break;
		default:
			System.out.println("학점=A");
			break;
		}
		
	}

}


