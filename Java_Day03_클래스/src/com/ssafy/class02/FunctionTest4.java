package com.ssafy.class02;

import java.util.Random;

public class FunctionTest4 {
	public static void main(String[] args) {
		boolean homework;
		
		System.out.println("아침에 일어난다.");
		move("교육장", "대중교통");
		homework = edu(); 	// edu()라는 메소드의 리턴 값이 boolean이므로
							//homework 변수 역시 자료형을 boolean으로 하여야 한다.
		move("집", "대중교통");
		if (homework) {
			System.out.println("과제를 해결한다.");
		} else {
			System.out.println("야호! 과제가 없다!");
		}
		System.out.println("잔다");
	}
	
	// 모듈화 : 공통적인 걸 뽑아서 코드의 재사용성을 높인다.
	// 반환형을 void(반환값 없음)에서 boolean으로 바꿈
	// return true/false로 반환값을 명시해야 한다.
	public static boolean edu() {
		// static : 미리 사용할 수 있다.
		System.out.println("오전 수업을 듣는다.");
		System.out.println("점심을 먹는다");
		System.out.println("오후 수업을 듣는다.");
		
//		// 과제 유무 리턴
//		// 랜덤 과제 발생기
//		Random random = new Random();
//		return random.nextBoolean(); // 랜덤하게 true 혹은 false를 반환한다.
		return new Random().nextBoolean(); // 재사용은 어렵지만 이렇게 변수에 담지 않고 바로 사용할 수도 있다.
	}
	
	public static void move(String destination, String vehicle) {
		System.out.println(destination + "으로 " + vehicle + "(을)를 이용하여 이동한다.");
	}

}
