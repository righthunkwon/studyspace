import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 현재 시스템의 날짜, 시간 관련 객체 만들기
		// static이 있는 메소드 : 클래스명.메소드명()
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		
		// 원하는 날짜와 시간으로 변경할 때는 set() 메소드를 사용한다.
		// set(int field, int value) (원하는 영역, 원하는 값 기입)
		// set(int year, int month, int date)
		// set(int year, int month, int date, int hourOfDay, int minute) 
		// set(int year, int month, int date, int hourOfDay, int minute, int second)
		
		now.set(2024, 2-1, 11); // 연도, 월, 날짜 변경(월은 -1을 해준다)
		now.set(Calendar.YEAR, 2021); // 연도만 변경
		
		// 값을 구할 때는 get() 메소드를 사용한다.
		// 연도 구하기
		int year = now.get(Calendar.YEAR); // YEAR은 1부터 시작(정상)
		System.out.println("year : " + year); 

		// 월 구하기
		int month = now.get(Calendar.MONTH) + 1; // MONTH는 0부터 시작(+1)
		System.out.println("month : " + month);
		
		// 일 구하기
		int date = now.get(Calendar.DAY_OF_MONTH); // DAY_OF_MONTH는 1부터 시작(정상)
		System.out.println("day : " + date);
		
		// 요일 구하기
		int day = now.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK 1부터 시작 (일요일:1, 토요일:7) (일요일이 시작!)

		String dayStr = "";
		switch (day) {
		case 1: dayStr = "일"; break;
		case 2: dayStr = "월"; break;
		case 3: dayStr = "화"; break;
		case 4: dayStr = "수"; break;
		case 5: dayStr = "목"; break;
		case 6: dayStr = "금"; break;
		case 7: dayStr = "토"; // 마지막 break; 는 생략 가능
		}
		
		// 오늘은 2023-01-04 수요일입니다.
		System.out.println("오늘은 " + year + "-" + month + "-" + date + " " + dayStr + "요일입니다.");
		System.out.println(now.get(Calendar.DAY_OF_YEAR)); // 출력된 날짜의 일
		
		// now의 날짜 정보에서 월의 마지막 날 구하기
		System.out.println("마지막 날 : " + now.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

}
