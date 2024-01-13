package com.ssafy.class02;

public class FunctionTest3 {
	public static void main(String[] args) {
		// shift + enter를 누르면 커서가 중간에 있어도 아랫줄로 이동한다.
		System.out.println("아침에 일어난다.");
		move("교육장", "대중교통");
		edu();
		move("집", "대중교통");
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
	
	public static void move(String destination, String vehicle) {
		System.out.println(destination + "으로 " + vehicle + "(을)를 이용하여 이동한다.");
	}

}
