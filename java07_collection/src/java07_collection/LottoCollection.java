package java07_collection;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LottoCollection {

	public LottoCollection() {
	}
	public void start() {
		Scanner scan = new Scanner(System.in);
		
		// 게임수 입력
		System.out.print("게임 수=");
		int cnt = scan.nextInt();
		
		// 번호 출력
		for(int i=1; i<=cnt; i++) { 
			Set set = new TreeSet();

			for(int j=0; set.size()<7; j++) {
				Random ran = new Random();
				int number = ran.nextInt(45)+1;	// 1~45까지 난수 발생
				set.add(new Integer(number));	
				// 보너스 추가 방법?
			}
			System.out.print(set);
			System.out.println(", bonus=");

		}

	}

	public static void main(String[] args) {
		LottoCollection lc = new LottoCollection();
		lc.start();
	}

}




