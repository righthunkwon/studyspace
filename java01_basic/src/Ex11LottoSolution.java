import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex11LottoSolution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random(); // Random 클래스 : Math.random()
		
		// 로또 번호 생성기
		do { // 전체반복
			
			// 1. 게임 수 입력
			System.out.print("게임 수=");
			int cnt = scan.nextInt();
			
			for(int i=1; i<=cnt; i++) { // 게임 수 만큼 반복실행
				// 배열의 길이 설정(당첨번호 6자리 + 보너스 1자리)
				int[] lotto = new int[7]; //
				// 난수생성(총 7개)
				for(int j=0; j<lotto.length; j++) {
					lotto[j] = ran.nextInt(45)+1; // j번째에 1~45까지의 난수 뽑기
					// 중복검사 : 동일한 값이 존재하는지
					for(int k=0; k<j; k++) {
						if(lotto[k] == lotto[j]) {
							j--;
							break; // 해당 for문만을 탈출, 상위 for문으로 가서 j++와 만나 중복되었던 값을 없애고 다시 출력
						}
					}
				}
				// 난수생성 이후 출력
				int lottoNum[] = Arrays.copyOfRange(lotto, 0, 6); // 0이상 6미만, 6개를 뽑은 뒤 배열 lottoNum에 담는다.
				Arrays.sort(lottoNum); // 오름차순 정렬
				System.out.print(i+"게임="+Arrays.toString(lottoNum)); 
				
				// 보너스
				System.out.println(", bonus="+lotto[6]);
			}
			// 계속 여부 확인
			System.out.print("계속하시겠습니까(1:예, 2:아니오)?");
			int que = scan.nextInt();
			if (que==2) {
				break;
			} else if (que==1) {
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		} while (true);
		System.out.println("프로그램을 종료합니다.");
	}

}
