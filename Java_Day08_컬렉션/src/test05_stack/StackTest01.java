package test05_stack;

import java.util.Stack;

public class StackTest01 {
	public static void main(String[] args) {
		// Stack
		// LIFO, 선입선출
		// 스택은 클래스
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// stack에 값 순서대로 집어넣기
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		// stack에서 값 순차적으로 꺼내기
		// 나중에 들어간 값이 먼저 나온다(LIFO, 후입선출)
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
