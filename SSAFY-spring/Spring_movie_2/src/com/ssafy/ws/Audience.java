package com.ssafy.ws;

import java.util.Random;

public class Audience implements Person {

	@Override
	public void doSomething() throws CallException {
		System.out.println("영화를 봅니다.");
		
		// 확률적 예외 발생
		if (new Random().nextBoolean()) {
			throw new CallException();
		}
	}
}
