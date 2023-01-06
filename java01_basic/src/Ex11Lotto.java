import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex11Lotto {
		// 미완성
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("게임 수=");
		int playTimes = scan.nextInt();
		
		Random random = new Random();
		int[] lotto = new int[6];

		fin:while (true) {
		// 게임 수 만큼 반복
		for (int i=0; i<playTimes; i++) {
			// 랜덤번호 생성
			for (i = 0; i < lotto.length; i++) {
				lotto[i] = random.nextInt(45) + 1;
				// 중복번호 제거
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}

			// 오름차순 정렬
			for (i = 0; i < lotto.length; i++) {
				for (int j = i + 1; j < lotto.length; j++) {
					if (lotto[i] > lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
			}
			System.out.println("계속하시겠습니까(1:예, 2:아니오)?");
			int que = scan.nextInt();
			if(que!=1) {
				System.out.println("프로그램이 좋료되었습니다.");
				break fin;
			}
			// 랜덤번호 출력 (미구현)
			System.out.println(playTimes+"게임=" + Arrays.toString(lotto));
		}
		}
	}
}