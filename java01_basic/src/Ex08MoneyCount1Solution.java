import java.util.Scanner;

public class Ex08MoneyCount1Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열 이용 방법
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		System.out.print("금액 입력=");
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
	}

}
