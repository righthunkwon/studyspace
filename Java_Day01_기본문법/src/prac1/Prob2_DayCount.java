package src.prac1;

import java.util.Scanner;

public class Prob2_DayCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("월과 일을 입력하세요.");
		String date = sc.nextLine();
		String[] dateArr = date.split(" ");

		int month = Integer.parseInt(dateArr[0]);
		int day = Integer.parseInt(dateArr[1]);
		int totalDay = 0;

		switch (month) {
		case 12:
			totalDay += 30; // 11월의 일 수
		case 11:
			totalDay += 31; // 10월의 일 수
		case 10:
			totalDay += 30; // 9월의 일 수
		case 9:
			totalDay += 31; // 8월의 일 수
		case 8:
			totalDay += 31; // 7월의 일 수
		case 7:
			totalDay += 30; // 6월의 일 수
		case 6:
			totalDay += 31; // 5월의 일 수
		case 5:
			totalDay += 30; // 4월의 일 수
		case 4:
			totalDay += 31; // 3월의 일 수
		case 3:
			totalDay += 28; // 2월의 일 수
		case 2:
			totalDay += 31; // 1월의 일 수
		case 1:
			totalDay += day;
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		System.out.printf("%d월 %d일은 %d번째 날입니다.", month, day, totalDay);

	}

}
