package com.ssafy.class02;

public class FunctionTest2 {
	public static void main(String[] args) {
		// shift + enter를 누르면 커서가 중간에 있어도 아랫줄로 이동한다.
		System.out.println("아침에 일어난다.");
		System.out.println("대중교통으로 교육장에 이동한다.");
		edu();
		System.out.println("대중교통으로 집에 이동한다.");
		System.out.println("과제를 해결한다.");
		System.out.println("잔다");
	}
	
	// 모듈화 : 공통적인 걸 뽑아서 코드의 재사용성을 높인다.
	public static void edu() {
		// static : 미리 사용할 수 있다.
		System.out.println("오전 수업을 듣는다.");
		System.out.println("점심을 먹는다");
		System.out.println("오후 수업을 듣는다.");
	}

}
