import java.util.Scanner;

public class IfElseIfTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// if~else if문 : 분류 기준이 두 개 이상일 때
		// 90~100 A 학점, 80~89 B학점, 70~79 C학점, 60~69 D학점, 0~59 F학점 
		
		// 학점
		System.out.print("점수 입력=");
		int kor = scan.nextInt();
		String grade = "A"; // char grade = 'A';도 가능
		
		if (kor >= 90) {
			grade = "A";
		} else if (kor >= 80) {
			grade = "B";
		} else if(kor >= 70) {
			grade = "C";
		} else if(kor >= 60) {
			grade = "D";
		} else {
			grade = "E";
		}
		
		System.out.println("학점 : " + grade + "학점");
	}
	
}
