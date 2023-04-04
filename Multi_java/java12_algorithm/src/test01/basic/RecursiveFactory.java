package test01.basic;

import java.util.Scanner;

public class RecursiveFactory {

	// 입력받은 임의의 값까지 팩토리얼(!) 구하기
	// (1) for문
	static int factorialFor() {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt(); 
		int fact = 1; // 초기값
		for(int i=input; i>=1; i--) { // input * (input-1) * ...
			fact *=i;
		}
		return fact;
	}
	
	// (2) while문
	static int factorialWhile() {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt(); 
		int fact = 1; // 초기값
		while(input>0) {
			fact *= input;
			input--;
		}
		return fact;
	}
	
	// (3) 반환형이 없는 재귀호출 : 결과를 저장할 변수 필요
	static int fact = 1;
	
	static void factorialRecursive(int n) {
		if(n==0) {
			return;
		}
		fact *= n;
		factorialRecursive(n-1); // 재귀호출
	}
	
	// (4) 반환형이 있는 재귀호출
	static int factorialRecursive2(int n) {
		if(n==1) return 1;
		return n * factorialRecursive2(n-1);
	}
	
	public static void main(String[] args) {
		// 입력받은 임의의 값까지 팩토리얼(!) 구하기
		// for 문
		System.out.println(factorialFor());
		
		// while 문
		System.out.println(factorialWhile());
		
		// 반환형이 없는 재귀호출
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		factorialRecursive(input); // 재귀 메소드 호출
		System.out.println(fact);
		
		// 반환형이 있는 재귀호출
		int input2 = scan.nextInt();
		System.out.println(factorialRecursive2(input2));
	}

}

	/*
			재귀함수(recursive function)
						
					함수 내부에서 직접 혹은 간접적으로 자기 자신을 호출하는 함수.
					일반적으로 재귀적 정의를 통해 재귀함수를 구현.
					기본부분(basic part)와 유도 부분(inductive part)으로 구성.
					재귀함수의 호출은 프로그램 메모리 구조에서 스택을 사용하므로 성능저하 가능성 존재.
	*/
