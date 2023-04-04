import java.util.Calendar;
import java.util.Scanner;

public class CalendarObject {
	
	// 기능구현을 편리하게 하기 위한 각 메소드를 통합해주는 메소드(마지막에 구현)
	public void start() {
		// 연도
		int year = inputData("년도");
		
		//월
		int month = inputData("월");
		
		// 요일
		int week = getWeek(year, month);
		
		// 마지막 날
		int lastDay = getLastDay(year, month);
		
		// 제목
		titlePrint(year, month);
		
		// 공백
		spacePrint(week);
		
		// 날짜
		dayPrint(lastDay, week);
	}
	
	
	// 입력 (년도, 월)
	public int inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + " : ");
		return scan.nextInt();
	}

	// 요일구하기(1일)
	public int getWeek(int year, int month) {
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, 1);
		return now.get(Calendar.DAY_OF_WEEK);
	}

	// 마지막날 구하기
	public int getLastDay(int year, int month) {
		int lastDay = 31;
		switch (month) {
		// 30일 끝
		case 4: // lastDay = 30; break; break를 만나지 않으면 case문이 멈추지 않지만 lastDay의 값이 동일하므로 생략해도 된다.
		case 6: // lastDay = 30; break;
		case 9: // lastDay = 30; break;
		case 11:
			lastDay = 30;
			break;

		// 28일, 29일 끝(2월)
		case 2:
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				// true : 윤년
				lastDay = 29;
			} else {
				// false : 평년
				lastDay = 28;
			}
		}
		return lastDay;

	}
	// 타이틀 출력
	public void titlePrint(int year, int month) {
		System.out.println("\t\t     "+year+"년 "+month+"월");
		weekTitle();
	}
	public void weekTitle() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");

	}
	
	// 공백출력
	public void spacePrint(int week) {
		for(int i=1; i<week; i++) {
			System.out.println("\t");
		}
	}
	
	// 날짜출력
	public void dayPrint(int lastDay, int week) {
		for(int i=1; i<=lastDay; i++) {
			System.out.print(i+"\t");
			if((week-1+i)%7==0) {
				System.out.println();
			}
		}
	}
}