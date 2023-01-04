import java.util.Scanner;

public class Ex08Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 한 학생의 국어, 영어, 수학, 물리, 과학, 체육 점수를 입력받아 총점, 평균을 구하라.
		
		String msg[] = {"국어","영어","수학","물리","과학","체육"};
		
		// 각 과목의 점수, 총점, 평균을 담을 배열형 변수 선언
		int score[] = new int[8];
		
		// 점수 입력(반복문 활용)
		for(int i=0; i<msg.length; i++) {
			System.out.print(msg[i]+"=");
			score[i] = scan.nextInt();
		}
		
		// 총점
		
		// 평균
		
		for(int d : score) {
			System.out.println(d);
			
		}
	}

}
