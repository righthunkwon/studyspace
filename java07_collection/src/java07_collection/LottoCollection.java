package java07_collection;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoCollection {
	// 멤버변수에 만들어두면 전체 객체(메서드)에 적용되므로 편리하다.
	Scanner scan = new Scanner(System.in); 
	Random random = new Random();
	
	public LottoCollection() {
	}
	
	// 전체 기능 구현 메서드
	public void gameStart() {
		do {
			int cnt = gameCount();
			for(int i=1; i<=cnt; i++) {
				System.out.print(i+"게임=");
				createLotto();
			}
			if(!endQuestion()) { // true: 계속, false: 중지 , ! = 부정연산자
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		} while(true);
	}
	
	// 개별 기능 구현 메서드(1) : 게임 수 입력
	public int gameCount() {
		do {
			try {
				System.out.print("게임 수->");
				String cntString = scan.nextLine();
				int cnt = Integer.parseInt(cntString); // 1~10만 정상 데이터, 이상의 숫자, 문자는 예외처리
				
				// 게임 수의 최대, 최소값 범위 확인
				if(cnt>=1 && cnt<=10) {
					// 정상적인 게임 수(1~10)
					return cnt;
				} else {
					// 비장상적인 게임 수(나머지 게임 수)
					System.out.println("게임 수를 1~10까지 입력하세요.");
				}
			} catch(NumberFormatException nnf) {
				// 게임 수가 숫자가 아닐 경우의 예외처리
				System.out.println("숫자를 입력하세요.");
			}
		} while(true);
	}
	
	// 개별 기능 구현 메서드(2) : 번호 생성(1개)
	public void createLotto() {
		// 번호 6개와 보너스 번호 1개를 생성
		// 정렬, 중복 검사 -> TreeSet 활용
		TreeSet<Integer> ts = new TreeSet<>();
		int ran = 0; // 새로 생성하는 번호, 마지막으로 생성 번호, 보너스 번호
		while(true) {
			ran = random.nextInt(45)+1; // random.nextInt(n)은 0부터 n까지의 숫자를 뽑으므로 +1을 하여 1~45까지의 숫자를 구한다.
			ts.add(ran); // TressSet에 추가
			if(ts.size()==7) { // 7개가 되면 난수 생성 중지
				break;
			}
		}
		// 마지막 생성 번호는 ran이 가지고 있다.
		ts.remove(ran); // 보너스 번호 TreeSet에서 지운다.
		System.out.print(ts.toString()); // [d, d, d, d, d, d] (오름차순)
		System.out.println(", bonus="+ran);
	}
	
	// 개별 기능 구현 메서드(3) : 계속 여부 확인
	public boolean endQuestion() {
		// y, Y : 예 / n, N : 아니오 / 그외 : 다시 질문
		do {
			System.out.print("계속하시겠습니까(y or Y:예, n or N:아니오)?");
			String yn = scan.nextLine();
			// 문자가 같은지를 판단하기 위해서는 ==가 아니라 equals()를 사용해야 한다.
			// equals() : 대소문자 구별, equalsIgnoreCase() : 대소문자 구별 X
			if(yn.equalsIgnoreCase("Y")) {
				// 계속한다.
				return true;
			} else if(yn.equalsIgnoreCase("N")) {
				// 그만한다.
				return false;
			} 
		} while(true);
	}
	
		public static void main(String[] args) {
			LottoCollection lotto = new LottoCollection();
			lotto.gameStart();
	}

}
