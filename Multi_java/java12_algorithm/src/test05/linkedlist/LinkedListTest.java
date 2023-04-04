package test05.linkedlist;

import java.util.Scanner;

public class LinkedListTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu;
		Data data;
		LinkedListData<Data> list = new LinkedListData<Data>();
		
		// 메뉴 만들기
		do {
			System.out.print("1: 머리에 노드를 삽입,  2: 꼬리에 노드를 삽입, "
					+ "3: 머리 노드 삭제,  4: 선택 노드 삭제,  5: 모든 노드 출력,  6: 종료  -->");
			menu = Integer.parseInt(scan.nextLine());
			
			switch(menu) {
			case 1:
				System.out.println("머리에 노드를 삽입");
				data = new Data();
				System.out.print("번호 입력: ");
				data.setNo(Integer.parseInt(scan.nextLine()));
				System.out.print("이름 입력: ");
				data.setName(scan.nextLine());
				list.addFirst(data);
				break;
			case 2:
				System.out.println("꼬리에 노드를 삽입");
				data = new Data();
				System.out.print("번호 입력: ");
				data.setNo(Integer.parseInt(scan.nextLine()));
				System.out.print("이름 입력: ");
				data.setName(scan.nextLine());
				list.addLast(data);
				break;
			case 3:
				System.out.println("머리 노드 삭제");
				list.removeFirst();
				break;
			case 4:
				System.out.println("선택 노드 삭제");
				list.removeCurrent();
				break;
			case 5:
				list.dump();
				break;
			}
		} while(menu != 6);
		System.out.println("프로그램이 종료되었습니다.");
	}

}
