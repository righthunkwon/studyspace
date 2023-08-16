
public class Stack_01_구현 {
	// top은 배열에서 요소가 존재하지 않는 마지막 index
	// top의 초기값으로는 배열의 맨 처음에 값을 넣기 위해 -1 대입
	private static int top = -1; 
	private static int[] stack = new int[5];
	

	public static void main(String[] args) {
		
	}

	private static boolean isEmpty() {
		// 비어있으면 true, 차있으면 false
		return top == -1;
	}

	private static boolean isFull() {
		// 포화면 true, 아니면 false
		return top == stack.length - 1;
	}
	
	private static void push(int value) {
		// 배열로 만들었으므로 범위 체크
		if (isFull()) {
			System.out.println("배열이 가득차 요소를 추가할 수 없습니다.");
		} else {
			stack[++top] = value;
		}
	}
	
	private static int pop() {
		if (isEmpty()) {
			System.out.println("배열이 비어있어 요소를 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		} else {
			// top이 -1 되었으므로 이후에 push할 경우 값이 덮어지므로 삭제할 필요가 없다.
			int popval = stack[top--];
			return popval;
		}
	}
	
	private static int peek() {
		if (isEmpty()) {
			System.out.println("배열이 비어있어 요소를 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		} else {
			int peekval = stack[top];
			return peekval;
		}
	}
}
