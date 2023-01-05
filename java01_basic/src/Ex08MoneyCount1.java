import java.util.Scanner;

public class Ex08MoneyCount1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열 이용 방법
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 10, 1};

		System.out.print("금액을 입력하세요 : ");
		int price = scan.nextInt();
		
		for (int i=0; i<money.length; i++) {
			if((price/money[i]) >= 1) {
				if(money[i] >= 1000) {
					System.out.println(money[i]+"원="+(price/money[i])+"장");
					price = price%money[i];
				} else {
					System.out.println(money[i]+"원="+(price/money[i])+"개");
					price = price%money[i];
				}
			}
		}
		
		
		
	}

}
