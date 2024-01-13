import java.util.Scanner;
import java.util.Stack;
import java.util.Stack;

public class Stack_07_실행취소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> CtrlZ = new Stack<>(); // 뒤로
		Stack<String> CtrlY = new Stack<>(); // 알으로
		String work = ""; // 현재 작업
		
		while(true) {
			System.out.println("1. 새로운 작업");
			System.out.println("2. Ctrl+Z");
			System.out.println("3. Ctrl+Y");
			System.out.println("0. 종료");
			
			// 메뉴 선택
			System.out.print("메뉴를 선택하세요: ");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				// 새로운 작업 추가
				// 1. 현재 작업을 Z에 넣는다.
				// 2. 새로운 작업을 입력 받는다.
				// 3. Y를 비운다.
					// 3-1. clear();
					// 3-2. 새로운 스택 생성(new)
					// 3-3. empty가 될 때까지 pop
				// 4. 현재 작업 출력(확인용)
				CtrlZ.push(work);
				work = sc.next(); // 공백이 없는 상태의 작업이 들어온다고 가정
				CtrlY.clear();
				System.out.println(work);
				break;
			case 2: 
				// 실행취소
				// 1. 현재 작업을 Y에 넣는다.
				// 2. Z에서 작업을 꺼내 현재 작업에 넣는다.
				// 3. 현재 작업 출력(확인용)
				if (CtrlZ.isEmpty()) {
					System.out.println("이전 작업이 없습니다.");
				} else {
					CtrlY.push(work);
					work = CtrlZ.pop();
					System.out.println(work); 
				}
				break;
			case 3: 
				// 실행취소를 취소
				// 1. 현재 작업을 Z에 넣는다.
				// 2. Y에서 작업을 꺼내 현재 작업에 넣는다.
				// 3. 현재 작업 출력(확인용)
				if (CtrlY.isEmpty()) {
					System.out.println("현재 작업이 가장 최신 작업입니다.");
				} else {
					CtrlZ.push(work);
					work = CtrlY.pop();
					System.out.println(work);
				}
				break;
			default:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
