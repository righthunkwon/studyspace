package java07_collection;

import java.util.Scanner;

public class LinkedListMain {
	
	public LinkedListMain() {
		
	}
	public void start() {
		Scanner scan = new Scanner(System.in);
		LinkedListTest llt = new LinkedListTest();
		
		do {
			try {
				System.out.print("메뉴선택[1:in, 2:out]=");
				// 1 -> PersonDTO 객체를 만들어 LinkedList 추가
				// 2 -> LinkedList에서 제일 앞에 있는 객체 꺼내기
				int menu = scan.nextInt(); // 정수 이외에 다른 값을 입력받았을 때 -> 예외 처리(try-catch-finally)
				switch(menu) {
				case 1: llt.inGuest(); break;
				case 2: llt.outGuest(); break;
				default: System.out.println("잘못 입력하셨습니다."); // 잘못된 정수를 입력받았을 때(else = default)
				}
			} catch(Exception e) {
				System.out.println("메뉴를 다시 입력하세요."); break;
			}
		} while(true);
	}
	
	public static void main(String[]args) {
		new LinkedListMain().start();
	}
	
	
}
