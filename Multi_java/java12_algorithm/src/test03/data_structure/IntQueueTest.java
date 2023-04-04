package test03.data_structure;

import java.util.Scanner;

import test03.data_structure.IntQueue.EmptyIntQueueException;
import test03.data_structure.IntQueue.OverflowIntQueueException;

public class IntQueueTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// queue 생성
		IntQueue que = new IntQueue();
		
		while(true) {
			System.out.print("(1)ENQUEUE (2)DEQUEUE (3)PEEK (4)데이터 확인 (5)데이터 찾기 (6)큐정보표시 (0)종료 -->");
			int menu = scan.nextInt();
			// 종료(0)
			if (menu==0) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
			switch(menu) {
			case 1: // 인큐(1): 리어에 데이터를 삽입
				System.out.print("추가할 데이터: ");
				int data = scan.nextInt();
				try {
					int enqueData = que.enqueue(data);
					System.out.println("enqueue처리한 값은 "+enqueData+"입니다.");
				} catch(OverflowIntQueueException oioe) {
					System.out.println("queue가 가득찼습니다.");
				}
				break;
			case 2: // 디큐(2): 프론트의 데이터를 삭제
				try {
					int dequeData = que.deque();
					System.out.println("dequeue처리한 값은 "+dequeData+"입니다.");
				} catch(EmptyIntQueueException eiqe) {
					System.out.println("queue가 비어있습니다.");
				}
				break;
			case 3: // 피크(3): 프론트의 데이터 가져오기(삭제되지 않음)
				try {
					int firstData = que.peek();
					System.out.println("queue의 front 값은 "+firstData+"입니다.");
				} catch (EmptyIntQueueException eiqe) {
					System.out.println("queue가 비어있습니다.");
				}
				break;
			case 4: // 데이터 확인(4)
				System.out.println(que.dataView()+"\n");
				break;
			case 5: // 데이터 찾기(5)
				System.out.print("찾을 값: ");
				int searchData = scan.nextInt();
				int index = que.indexOf(searchData);
				if(index>=0) {
					System.out.println(index+"위치에 "+searchData+"가 있습니다.");
				} else {
					System.out.println(searchData+"는 queue에 존재하지 않습니다.");
				}
				break;
			case 6: // 큐정보표시(6) : 용량, 데이터의 수, 비어있는지 여부, 가득찼는지 여부, 마지막 데이터 출력 후 삭제
				System.out.println("큐의 용량: "+que.capacity());
				System.out.println("큐의 현재 데이터 수: "+que.size());
				System.out.println("isEmpty: "+que.isEmpty());
				System.out.println("isFull: "+que.isFull());
				System.out.println("큐의 마지막 데이터: "+que.peekLast());
				System.out.println("큐의 마지막 데이터 삭제: "+que.pollLast());
				break;
			default :
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
	}

}
