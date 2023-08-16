
public class Stack_03_괄호검사 {
	//	- 괄호 검사
	//    - 괄호의 종류 : 대괄호, 중괄호, 소괄호
	//    - 여는 괄호의 개수와 닫는 괄호의 개수는 같아야 한다.
	//    - 같은 괄호에서 여는 괄호는 닫는 괄호보다 먼저 나와야 한다.
	//    - 괄호 사이에는 포함관계만 존재한다.
	//        - 풀이 방법
	//            1. 문자 배열
	//            2. API 활용 → Stack<Character>
	//        - 여는 괄호일 경우 stack에 담고, 닫는 괄호일 경우 직전 요소와 비교하여 괄호의 종류가 일치할 경우 pass, 이외의 경우 fail
	//        - 만약 괄호 배열 순회가 끝났는데 스택에 괄호가 남아 있다면 남는 괄호이므로 fail
}
