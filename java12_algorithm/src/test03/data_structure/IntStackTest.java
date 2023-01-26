package test03.data_structure;

import java.util.Scanner;
import test03.data_structure.IntStack.EmptyIntStackException;
import test03.data_structure.IntStack.OverflowIntStackException;

public class IntStackTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 스택 생성
		IntStack stack = new IntStack(10);
		
		while(true) {
			System.out.println("현재 데이터수: "+ stack.size() +  ", 스택의 크기: "+stack.capacity());
			System.out.print("(1)PUSH (2)POP (3)PEEK (4)DUMP (5)SEARCH (6)EMPTY (7)REMOVE (8)스택정보표시 (0)종료 -->");
			int menu = scan.nextInt();
			
			// 종료(0)
			if(menu==0) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
			switch(menu) {
			case 1: // PUSH(1): 데이터 담기
				System.out.print("데이터 값: ");
				int data = scan.nextInt();
				try {	
					stack.push(data);
				} catch(OverflowIntStackException oise) {
					System.out.println("스택이 가득찼습니다.");
				}
				break;
				
			case 2: // POP(2): 마지막 값 꺼내기
				try {
					int popData = stack.pop();
					System.out.println("pop처리한 값은 "+popData+"입니다.");
				} catch(EmptyIntStackException eise) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
			case 3: // PEEK(3): 최상단 값 확인
				try {	
					int peekData = stack.peek();
					System.out.println("peek처리한 값은 "+peekData+"입니다.");
				} catch(EmptyIntStackException eise) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
			case 4: // DUMP(4): 스택의 모든 데이터를 출력
				stack.dump();
				break;
			case 5: // SEARCH(5): 찾는 데이터의 위치 반환
				System.out.print("찾는 데이터: ");
				int searchData = scan.nextInt();
				int result = stack.indexOf(searchData);
				if(result>=0) {
					System.out.println(searchData+"는 "+result+"번째에 있습니다.");
				} else {
					System.out.println(searchData+"는 스택에 존재하지 않습니다.");
				}
				break;
			case 6: // EMPTY(6): 스택 비움
				stack.empty();
				break;
			case 7: // REMOVE(7): 원하는 데이터 삭제
				System.out.print("삭제할 값: ");
				int delData = scan.nextInt();
				boolean delResult = stack.remove(delData);
				if(delResult) {
					System.out.println(delData+"가 스택에서 삭제되었습니다.");
				} else {
					System.out.println(delData+"가 존재하지 않습니다.");
				}
				break;
			case 8: // 스택정보표시(8) : 용량, 데이터수, 스택의 상태
				System.out.println("용량: "+ stack.capacity());
				System.out.println("현재 데이터 수: "+stack.size());
				System.out.println("스택이 비어"+ (stack.isEmpty() ? "있습니다." : "있지 않습니다."));
				System.out.println("스택이 가득 차"+ ((stack.isFull() ? "있습니다.\n" : "있지 않습니다.\n")));
				break;
			default :
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
	}

}


