package java07_collection;

import java.util.Stack;

public class StackTest {

	public StackTest() {
		// Stack 객체 생성
		Stack<String> nameStack = new Stack<>();
		
		// push : 값 추가(순서대로 차곡차곡 아래에 담는다)
		nameStack.push("권정훈");
		nameStack.push("이재용");
		nameStack.push("이건희");
		nameStack.push("최태원");
		nameStack.push("정주영");
		
		/*
			stack에 담겨있는 구조
			
				| 정주영 |
				| 최태원 |
				| 이건희 |
				| 이재용 |
				| 권정훈 |
				ㅡㅡㅡㅡㅡㅡ
		 */
		
		while(!nameStack.empty()) { // 비어있으면 true, 객체가 있으면 false -> !연산자로 변경 -> 비어있으면 false, 객체가 있으면 true
			System.out.println(nameStack.pop()+", "+nameStack.size()); 
		}
		
		/*
				논리 부정 연산자(！)
					: ! 연산자는 피연산자가 true이면 false를, false이면 true를 결과로 반환한다.
		*/
	}

	public static void main(String[] args) {
		new StackTest();
	}

}
