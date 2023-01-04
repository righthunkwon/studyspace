import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

public class Ex05ConsoleCalendar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 연, 월을 입력받아 달력 출력하기
		// 입력값
		System.out.print("년도=");
		int inputYear = scan.nextInt();
		
		System.out.print("월=");
		int inputMonth = scan.nextInt();
		
		// 현재 날짜 시간 객체
		Calendar cal = Calendar.getInstance();
		
		// 입력받은 연, 월, 1일로 변경
		cal.set(inputYear, inputMonth-1, 1);
		
		// 1일이 무슨 요일인지
		int inputDay = cal.get(Calendar.DAY_OF_WEEK); // 1(일), 2(월), ... ,7(토)
		
		// 말일 계산하기
		// 30일 : 4, 6, 9, 11월
		// 31일 : 1, 3, 5, 7, 8, 10, 12월
		// 28일, 29일 : 2월 (4년에 한 번 2월은 29일로 끝난다(윤년). 단, 100으로 나눠지면 평년이다. 하지만, 400의 배수이면 해당 년도는 윤년이다.)
		
		// 31일 끝(기본값, 가장 많아서 기본값으로 설정)
		int lastDay = 31;
		
		switch (inputMonth) {
		// 30일 끝
		case 4: // lastDay = 30; break; break를 만나지 않으면 case문이 멈추지 않지만 lastDay의 값이 동일하므로 생략해도 된다.
		case 6: // lastDay = 30; break;
		case 9: // lastDay = 30; break;
		case 11: lastDay = 30; break;
		
		// 28일, 29일 끝(2월)
		case 2 : 
			if (inputYear%4==0 && inputYear%100!=0 || inputYear%400==0) {
				// true : 윤년
				lastDay = 29;
			} else {
				// false : 평년
				lastDay = 28;
			}
		}
		
		// 제목 출력
		System.out.println("\t\t"+inputYear+"년 "+inputMonth+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		// 공백 출력(1일 기준)
		for (int space=1; space<inputDay; space++) {
			System.out.print("\t");
		}
		
		// 날짜 출력
		for(int day=1; day<=lastDay; day++) {
			System.out.print(day+"\t");
			// 일주일마다 줄 바꿈
			if((inputDay-1+day)%7==0) {
				System.out.println();
			}
		}
	}
}