import java.util.Scanner;

public class Ex09MoneyCount2Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열 이용 X 방법
		
		// 화폐의 규칙 이용 : 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
		// 5로 나누고 2로 나누고
		int money = 50000; // 화폐 중 가장 큰 초기값
		int div = 5; //  다음 화폐를 구하기 위해 필요한 초기값
		
		System.out.print("금액 입력 : ");
		int won = scan.nextInt();
		
		while(won>0) {
			// 화폐수
			int cnt = won / money; 
			// 출력
			if(cnt>0) {
				System.out.print(money+"원="+cnt);
				String lbl = "장";
				if(money<=500) {
					lbl = "개";
				}
				System.out.println(lbl);
			}
			// 계산한 금액 빼주기
			won -= money*cnt;
			
			// 다음 화폐 만들기
			money /= div;
			// 화폐를 나눌값 변경(5->2, 2->5)
			if(div == 5) {
				div = 2;
			} else {
				div = 5;
			}
		}
	}

}
