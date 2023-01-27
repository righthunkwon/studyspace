package test04.sort;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoBubbleSortSol {
	// 멤버변수에 만들어두면 전체 객체(메서드)에 적용되므로 편리하다.
	Scanner scan = new Scanner(System.in); 
	Random ran = new Random();
	int lotto[] = new int[7];

	
	public LottoBubbleSortSol() {
	}
	
	// 전체 기능 구현 메서드
	public void gameStart() {
		do {
			int cnt = gameCount();
			for(int i=1; i<=cnt; i++) {
				System.out.print(i+"게임=");
				createLotto(); // 생성 및 중복제거
				lottoBubbleSort(lotto); // 정렬(BubbleSort)
				lottoOutput(lotto); // 출력
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
	
	// 개별 기능 구현 메서드(2) : 번호 생성(1세트), 중복제거
	public void createLotto() {
		// 번호 6개와 보너스 번호 1개를 생성
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = ran.nextInt(45)+1; // 0이상 45미만 --> +1 --> 1이상 46미만
			
			// 중복 제거
			for(int j=0; j<i; j++) { 
				if(lotto[i] == lotto[j]) { // i번째 번호를 다시 생성시킴으로써 중복 제거
					i--;
					break;
				}
			}
		}
	}
	
	// 개별 기능 구현 메서드(3) : 정렬(BubbleSort)
	public void lottoBubbleSort(int lotto[]) {
		for(int i=0; i<lotto.length-2; i++) {
			for(int j=0; j<lotto.length-2-i; j++) {
				if(lotto[j] > lotto[j+1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
					}
			}
		}
	}
	
	// 개별 기능 구현 메서드(4) : 출력
	public void lottoOutput(int lotto[]) {
		String txt = "[";
		for(int i=0; i<lotto.length-1; i++) {
			txt += lotto[i];
			if(i==lotto.length-2) {
				txt += "], ";
			} else {
				txt += ", ";
			}
		}
		System.out.println(txt+"bonus="+lotto[6]);
	}
	
	// 개별 기능 구현 메서드(5) : 계속 여부 확인
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
			LottoBubbleSortSol lotto = new LottoBubbleSortSol();
			lotto.gameStart();
	}

}
