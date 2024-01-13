import java.util.Scanner;
import java.util.Stack;

// 계산기 1
public class P_1222 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// test case
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			sc.nextInt(); // 계산식 문자열 길이
			String infix = sc.next(); // 계산식 문자열
			System.out.printf("#%d %d\n", t, Calculate(ChangeInToPost(infix)));
		}
	}

	// 중위표기식(infix)을 후위표기식(postfix)으로 변경하는 메소드
	// 후위표기식은 sb에 담고, 연산자는 stack에 담는다.
	private static String ChangeInToPost(String infix) {
		Stack<Character> stack = new Stack<>(); // 연산자
		StringBuilder sb = new StringBuilder(); // 후위표기식

		for (int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);
			if (ch == '+') { // 연산자
				stack.push(ch);
			} else { // 숫자
				sb.append(ch);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		String postfix = String.valueOf(sb);
		return postfix;
	}

	// 후위표기식을 계산하는 메소드
	private static int Calculate(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);

			if (ch >= '0' && ch <= '9') {
				// 후위표기식에서 숫자를 입력 받았을 경우
				stack.push(ch - '0'); // 문자를 숫자로 변환하여 스택에 담는다.

			} else {
				// 후위표기식에서 연산자를 입력 받았을 경우
				// 스택에서 숫자 두 개를 꺼낸 뒤, 연산을 하고 해당 연산의 결과를 다시 계산기 스택에 담는다.
				int n2 = stack.pop();
				int n1 = stack.pop();
				stack.push(n1 + n2);
			}
		}
		return stack.pop();
	}
}