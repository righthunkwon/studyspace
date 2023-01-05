import java.util.Scanner;

public class Ex09MoneyCount2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열 이용 X 방법
		System.out.print("금액을 입력하세요 : ");
		int price = scan.nextInt();
		int m1 = (price / 50000);
		price = price % 50000;
		int m2 = (price / 10000);
		price = price % 10000;
		int m3 = (price / 5000);
		price = price % 5000;
		int m4 = (price / 1000);
		price = price % 1000;
		int m5 = (price / 500);
		price = price % 500;
		int m6 = (price / 100);
		price = price % 100;
		int m7 = (price / 10);
		price = price % 10;
		int m8 = (price / 1);
		price = price % 1;

		if(m1 >= 1) {
		System.out.println("50000원=" + m1 + "장");
		} if (m2 >= 1) {
			System.out.println("10000원=" + m2 + "장");
		} if (m3 >= 1) {
			System.out.println("5000원=" + m3 + "장");
		} if (m4 >= 1) {
			System.out.println("1000원=" + m4 + "장");
		} if (m5 >= 1) {
			System.out.println("500원=" + m5 + "개");
		} if (m6 >= 1) {
			System.out.println("100원=" + m6 + "개");
		} if (m7 >= 1) {
			System.out.println("10원=" + m7 + "개");
		} if (m8 >= 1) {
			System.out.println("1원=" + m8 + "개");
		}
	}
}
