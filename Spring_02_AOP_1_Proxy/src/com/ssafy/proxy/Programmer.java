package com.ssafy.proxy;

import java.util.Random;

public class Programmer {
	
	public void coding() {
		
		System.out.println("컴퓨터 부팅");

		try {
			System.out.println("코드 작성");
			// 랜덤하게 예외 발생
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}
			System.out.println("Git push");
		} catch (Exception e) {
			// 예외 처리
			System.out.println("반차 내기");
		} finally {
			// 마지막에 항상 실행
			System.out.println("하루 끝");
		}

	}
}
