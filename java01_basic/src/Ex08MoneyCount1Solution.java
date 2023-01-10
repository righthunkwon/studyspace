import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08MoneyCount1Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열 이용 방법
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		try {
			System.out.print("금액입력=");
			int won = scan.nextInt();
			
			for(int i=0; i<money.length; i++) {
				int cnt = won / money[i];
				if(cnt>0) {
					System.out.print(money[i]+"원="+cnt);
					if (money[i] >= 1000) {
						System.out.println("장");
					} else {
						System.out.println("개");
					}
					won = won - money[i]*cnt;
				}
			}
		} catch (InputMismatchException ie) {
			System.out.println("올바른 값을 입력하세요(1 이상의 정수).");
			ie.printStackTrace();
			System.out.println(ie.getMessage());
		} finally {
			System.out.println("프로그램을 종료합니다.");
		}
	}

}
