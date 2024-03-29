
public class Stack_08_계산기 {
	public static void main(String[] args) {
		/*
		 * SWEA 문제
		 * 계산기 1: +
		 * 계산기 2: +*
		 * 계산기 3: +*()
		 * 
		 * 해당 문제에서는 /와 -가 없어서 pop과 연산순위를 고려하지 않아도 되지만 이를 고려하자
		 * (가령 , A / B = C 일때 B에 먼저 pop한 값을 넣고 다음 A에 pop한 값을 넣어야 한다.)
		 * 
		 * 
		 * 연산자 우선순위
		 * 조건문을 통해서 확인할 수도 있고, Map을 이용하여서도 가능하다
		 * Map<Character, Integer> priority = new HashMap<>();
		 * priority.put('+', 1);
		 * priority.put('-', 1);
		 * priority.put('*', 2);
		 * priority.put('/', 2);
		 * priority.put('(', 0); // 스택 내부 괄호로 가정
		 * 
		 * 
		 * 중위 -> 후위 표기
		 * 문자열로 중위표기식이 들어온다. Stack에 연산자를 담아야 한다.
		 * (1) 글자를 하나씩 읽는다(반복문)
		 * (2) 피연산자는 출력한다.
		 * (3) 연산자라면 ...
		 * 		(3-1) 스택이 공백상태라면 그냥 넣는다(push)
		 * 		(3-2) 스택이 공백상태가 아니면 top을 확인하고 현재값이 우선하면 push, 우선하지 않으면 있는 걸 pop하여 출력 후 push
		 * 		(3-3) 연산자 우선순위는 /* , +-, ( 이다. 
		 * 			(스택 밖의 괄호는 우선순위가 높지만 안의 괄호는 낮다.) 
		 * 			(괄호는 열린 괄호만 stack에 담고 닫힌 괄호가 나올 경우 열린 괄호를 만날 때까지 stack의 요소를 pop한다.)
		 * 
		 * 
		 * 후위 표기 -> 계산
		 * 문자열로 만들어진 후위표기식이 들어온다. Stack에 피연산자를 담는다.
		 * (1) 글자를 하나씩 읽는다(반복문)
		 * (2) 피연산자는 스택에 넣는다.
		 * (3) 연산자라면 필요한 피연산자의 개수만큼 꺼내어 계산하고 계산 결과를 다시 넣는다. 
		 * (4) stack이 남아있다면 다시 1번부터 반복
		 * (5) 다 읽고 처리했다면 pop하여 결과 출력
		 * 
		 * 
		 * 
		 * */
	}
}
