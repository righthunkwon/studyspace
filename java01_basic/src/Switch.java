import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// switch 문 : 범위가 없는 조건문(변수나 연산식에 따라 실행문을 선택하고 선택하면 break가 실행되어 탈출)
		// switch 문에서는 int 보다 작거나 같은 데이터형의 변수를 사용할 수 있다(byte, short, int, char, String).

		// 임의의 정수를 입력받아 1이면 빨강, 2이면 노랑, 3이면 파랑, 4이면 초록, 나머지 검정
		System.out.print("정수입력=");
		int intData = scan.nextInt();
		
		
		switch (intData) {
		case 1:
			System.out.println("빨강");
			break;
		case 2:
			System.out.println("노랑");
			break;
		case 3:
			System.out.println("파랑");
			break;
		case 4:
			System.out.println("초록");
			break;
		default:
			System.out.println("검정");
		}
	}

}
