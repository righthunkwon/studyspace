package test03.data_structure;

import java.util.Stack;
import java.lang.RuntimeException;
	/*
		스택(Stack)
			: 데이터를 일시적으로 저장하기 위해 사용하는 자료구조
			: "쌓다"라는 의미로, 데이터를 아래에서부터 순서대로 쌓음
			: 가장 마지막에 삽입된 자료가 가장 먼저 삭제되는 구조(일회용 종이컵을 하나씩 꺼내서 사용하는 것)
			: 즉, 데이터의 입력과 출력 순서는 후입선출(LIFO, Last in, First out)
			: push(삽입), pop(삭제), peek(최상단의 값 확인), dump(스택 전체 데이터 출력),
			  search(찾는 데이터의 위치 반환), 
			
	*/


public class IntStack {
	int max; // 스택의 크기 설정
	int pointer; // 포인터: 스택에 쌓여있는 데이터의 수
	int stack[]; // 배열의 초기값: null
	
	public IntStack() {
		// 배열(스택)의 크기를 설정하지 않을 경우 정수 20개의 데이터를 저장할 수 있도록 배열을 생성
		this(20); // 이 this문은 하단의 public IntStack(int capacity)에 대입되어 max를 20으로 만든다.
	}
	
	public IntStack(int capacity) {
		try {
			stack = new int[capacity];
			max = capacity;
			pointer = 0; // 초기 포인터
		} catch (OutOfMemoryError oome) {
			max = 0; // 예외 발생 시 stack의 크기를 초기화
		}
		
	}
	// 예외 클래스////////////////////////////////////////////////////////
	// PUSH 실행 시 스택에 데이터가 넘칠 때 발생시킬 예외 클래스(PUSH의 예외)
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			
		}
	}
	
	// POP 실행 시 스택에 데이터가 비어있는데 실행할 경우 발생시킬 예외 클래스(POP의 예외)
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
			
		}
	}
	///////////////////////////////////////////////////////////////////
	
	
	// 현재 데이터 수 
	public int size() {
		return pointer;
	}
	
	// 스택의 크기(확보된 메모리의 크기)
	public int capacity() {
		return max;
	}
	
	// 스택의 상태(스택이 비어있는지 아닌지)
	public boolean isEmpty() {
		return pointer<=0;
	}
	
	public boolean isFull() {
		return pointer == max;
	}
	
	
	// PUSH(데이터 담기)
	public int push(int data) throws OverflowIntStackException {
		// 스택이 오버플로우일 때 데이터를 푸시하면 예외 발생
		if(max<=pointer) {
			throw new OverflowIntStackException();
		}
		return stack[pointer++] = data;
	}
	
	// POP(데이터 꺼내기)
	public int pop() throws EmptyIntStackException {
		if(pointer<=0) {
			throw new EmptyIntStackException();
		}
		return stack[--pointer];
	}
	
	// PEEK(최상단 데이터 확인)
	public int peek() throws EmptyIntStackException{
		if(pointer<=0) {
			throw new EmptyIntStackException();
		}
		return stack[pointer-1];
	}
	
	// DUMP(스택의 전체 데이터 확인)
	public void dump() {
	/*
		if(pointer==0) { // 스택이 비어있는 경우
			System.out.println("스택의 데이터가 없습니다.");
		} else { // 스택에 데이터가 있는 경우
			for(int i=pointer-1; i>=0; i--) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}
	*/
		String stackStr = "[";
		for(int i=pointer-1; i>=0; i--) {
			stackStr += stack[i];
			if(i>0) {
				stackStr += ", ";
			}
		}
		stackStr += "]";
		System.out.println(stackStr);
	}
	
	// SEARCH(찾는 데이터의 위치 반환)
	public int indexOf(int data) {
		for(int i=pointer-1; i>=0; i--) {
			if(stack[i]==data) {
				return i;
			}
		}
		return -1; // 찾는 데이터가 존재하지 않을 때
	}
	
	// EMPTY(스택 비움) - 포인터의 값을 초기화
	public void empty() {
		pointer = 0;
	}
}
