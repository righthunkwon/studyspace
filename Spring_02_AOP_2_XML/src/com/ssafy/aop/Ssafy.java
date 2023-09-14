package com.ssafy.aop;

import java.util.Random;

public class Ssafy implements Person {

	// 싸피인의 일상
	@Override
	public void coding() {
		System.out.println("열심히 공부를 한다."); // 핵심관심사항
		if(new Random().nextBoolean()) {
			throw new OuchException();
		}
	}
}
