package test04.sort;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
	/*
		버블정렬을 활용하여 로또 번호 랜덤 출력하기
			
				- 단, 컬렉션 사용 불가
				- API 정렬 메소드 사용 불가
	*/

public class LottoBubbleSort {
	// 멤버변수에 만들어두면 전체 객체(메서드)에 적용되므로 편리하다.
	Scanner scan = new Scanner(System.in); 
	Random ran = new Random();
	
	public LottoBubbleSort() {
	}
	
	// 전체 기능 구현 메서드
	public void gameStart() {
		do {
			int cnt = gameCount();
			for(int i=1; i<=cnt; i++) {
				System.out.print(i+"게임= ");
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
		// BubbleSort를 활용하여 정렬 기능 추가
		// 중복 제거 기능 추가
		
		// 랜덤 숫자 생성
		int arr[] = new int[7];
		for(int i=0; i<arr.length; i++) {
			arr[i] = ran.nextInt(45)+1;
		}
		int bonus = arr[6];
		int mainNum[] = {arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]}; 
		
		// 버블정렬(단, 보너스 제외)
		for(int k=0; k<mainNum.length-1; k++) {
			for(int i=0; i<mainNum.length-1-k; i++) { // 버블정렬에서 마지막은 정렬할 수 없고 또 필요도 없으므로 arr.length에 -1을 해준다. 
				                                  // 또한, -k를 해줌으로써 불필요한 회전수를 줄일 수 있다.(이미 정렬된 곳은 불필요하게 또 정렬할 필요가 없기 때문! - 생각해보기)
				if(mainNum[i] > mainNum[i+1]) { // <-- 오름차순 (내림차순은 부등호 반대)
					int temp = mainNum[i];
					mainNum[i] = mainNum[i+1];
					mainNum[i+1] = temp;
				}
			}
		}
		// 정렬 이후 출력
		System.out.print("[");
		for(int j=0; j<mainNum.length; j++) {
			System.out.print(mainNum[j]);
			if(j != mainNum.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println(", bonus="+bonus);
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
			LottoBubbleSort lotto = new LottoBubbleSort();
			lotto.gameStart();
	}

}
