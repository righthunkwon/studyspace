package test01.control;

import java.util.Random;
import java.util.Scanner;

/*
	[처리조건]
	두 자리 수의 난수를 생성하여 맞추는 게임을 작성하라.
	
	[예시]
	난수=25일 때,
	
	숫자입력=56
	컴퓨터의 수가 더 작습니다.
	
	숫자입력=24
	컴퓨터의 수가 더 큽니다.
	
	숫자입력=25
	축하합니다. 3번만에 맞추셨습니다.
	계속하시겠습니까(Y/N)? (단, 소문자를 입력해도 반영되도록)
	
*/

public class NumberMarches {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int i = 0;
		
		// 두 자리 수 난수 생성
		int num = ran.nextInt(90) + 10; 
		int input = 0;

		
		while (num != input){
			// 값 입력
			System.out.print("숫자입력="); 
			input = scan.nextInt();
			
			// 횟수 증가
			i++;
			
			if (input > num) {
				System.out.println("컴퓨터의 수가 더 작습니다.");
			} else if (input < num) {
				System.out.println("컴퓨터의 수가 더 큽니다.");
			} else if (input == num) {
				System.out.println("축히합니다."+i+"번만에 맞추셨습니다.");
				System.out.print("계속하시겠습니까(Y/N)?");
				String doAgain = scan.nextLine();
				doAgain = scan.nextLine();
				
				if(doAgain =="y" || doAgain =="Y") { // 하나의 if에 여러 조건을 줄 때는 논리연산자를 활용한다.
					break;
				} else if (doAgain =="n" || doAgain =="N") {
					System.out.println("프로그램을 종료합니다.");
					break;
				} 
				
			}
		} 

	}

}
