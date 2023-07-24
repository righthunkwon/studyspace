package java04.control;

public class Switch01 {
	public static void main(String[] args) {
		// 월을 입력 받았을 때 각 월의 일수를 출력하여라.
		int month = 12;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month + "월은 31일입니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + "월은 30일입니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일입니다. (단, 윤년 고려 X)");
			break;
		default:
			System.out.println("잘못된 월입니다.");
			break;
		}

	}
}
