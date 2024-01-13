package com.ssafy.ws;

import java.util.Random;

public class Driver implements Person {

	@Override
	public void doSomething() throws GasException {
		System.out.println("열심히 운전을 합니다.");
		
		// 확률적 예외 발생
		if (new Random().nextBoolean()) {
			throw new GasException();
		}
	}
}
