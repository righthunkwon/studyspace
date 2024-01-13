import java.util.Scanner;
import java.util.Stack;

// 괄호 짝짓기
// 여는 괄호일 경우 stack에 담고, 닫는 괄호일 경우 직전 요소와 비교하여 괄호의 종류가 일치할 경우 pass, 이외의 경우 fail
public class P_1218 {
	// 여는 괄호와 닫는 괄호의 배열
	private static char[] open = { '[', '{', '(', '<' }; // 여는 괄호
	private static char[] close = { ']', '}', ')', '>' }; // 닫는 괄호
	
	// 여는 괄호인지 판단하는 메소드
	// 여는 괄호일 경우 true를 반환하여 stack에 조건 없이 담음
	private static boolean isOpen(char ch) {
		for (int i = 0; i < 4; i++) {
			if (ch == open[i]) {
				return true;
			}
		}
		return false;
	}

	// 닫는 괄호와 여는 괄호의 index가 같은 경우 같은 괄호로 판단
	// 여는 괄호의 index 판단
	private static int getOpenBracketIndex(char ch) {
		int index = 0;
		for (int i = 0; i < 4; i++) {
			if (ch == open[i]) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	// 닫는 괄호의 index 판단
	private static int getCloseBracketIndex(char ch) {
		int index = 0;
		for (int i = 0; i < 4; i++) {
			if (ch == close[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 괄호 문자의 수
			String str = sc.next(); // 괄호 문자의 문자열
			char[] carr = new char[n]; // 괄호 문자를 담을 배열
			for (int i = 0; i < n; i++) {
				carr[i] = str.charAt(i);
			}

			int ans = 1; // 유효성 판단(0:유효하지 않음, 1:유효)
			Stack<Character> stack = new Stack<>(); // 괄호 stack

			// 일단 한 번은 담는다.
			if (isOpen(carr[0])) {
				stack.push(carr[0]);
			} else { // 첫 글자가 닫는 괄호일 경우 유효하지 않음 
				ans = 0;
			}

			// 이후 stack에 괄호를 담으며 유효성 판단
			for (int i = 1; i < n; i++) {
				if (isOpen(carr[i])) { // 여는 괄호일 경우 담는다
					stack.push(carr[i]);
				} else { // 닫는 괄호일 경우 이전 괄호와 비교 후 index가 일치하면 담는다.
					stack.push(carr[i]);
					if(getCloseBracketIndex(stack.pop()) != getOpenBracketIndex(stack.pop())) {
						ans = 0;
						break;
					}	
				}
			}

            
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
