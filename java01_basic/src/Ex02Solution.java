import java.util.Scanner;

public class Ex02Solution {
		// 2번 에제 풀이
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 개별 점수 입력
		System.out.print("국어점수=");
		int korScore = scan.nextInt();
		
		System.out.print("영어점수=");
		int engScore = scan.nextInt();
		
		System.out.print("수학점수=");
		int mathScore = scan.nextInt();
		
		// 총점
		int tot = korScore + engScore + mathScore;
		System.out.println("총점=" + tot);
		
		// 평균
		double ave = (double)tot / 3; // tot / 3.0 과 동일
		System.out.println("평균=" + ave);
		
		String grade = "F";
		switch ((int)ave/10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println("학점=" + grade);
	}

}
