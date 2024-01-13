package src.prac1;

import java.util.Scanner;

public class Prac3_GameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.\n");
		System.out.println("1.5판3승");
		System.out.println("2.3판2승");
		System.out.println("3.1판1승\n");
		System.out.print("번호를 입력하세요.");
		int gameSet = sc.nextInt();
		int totalGame = 0;
		int userWin = 0;
		int comWin = 0;

		// 게임 수
		switch (gameSet) {
		case 1: // 5판 3승
			totalGame = 5;
			break;
		case 2: // 3판 2승
			totalGame = 3;
			break;
		case 3: // 1판 1승
			totalGame = 1;
			break;
		}

		// 게임
		for (int i = 0; i < totalGame; i++) {
			System.out.print("가위바위보 중 하나 입력 :");
			int userNum = sc.nextInt();
			int comNum = (int) (Math.random() * 3) + 1;
			if (userNum == 1 && comNum == 3) {
				System.out.println("이겼습니다!!!");
				userWin++;
			} else if (userNum == 2 && comNum == 1) {
				System.out.println("이겼습니다!!!");
				userWin++;
			} else if (userNum == 3 && comNum == 2) {
				System.out.println("이겼습니다!!!");
				userWin++;
			} else if (userNum == comNum) {
				System.out.println("비겼습니다!!!");
				continue;
			} else {
				System.out.println("졌습니다!!!");
				comWin++;
			}
		}
		
		// 결과 출력
		if (userWin > comWin) {
			System.out.println("### 유저 승!!!");
		} else if (userWin < comWin) {
			System.out.println("### 컴퓨터 승!!!");
		} else {
			System.out.println("### 무승부!!!");
		}
	}

}
