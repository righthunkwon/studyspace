package com.ssafy.ws;

// 공통관심사항 작성
public class MovieAspect {
	
	public void before() {
		System.out.println("영화관을 갑니다.");
	}
	
	public void afterReturning() {
		System.out.println("영화가 끝나고 나옵니다.");
	}
	
	public void afterThrowing(Throwable th) throws CallException {
		if (th instanceof CallException) {
			((CallException) th).handelException();
		}
	}
	
	public void after() {
		System.out.println("집에 갑니다.");
	}
}
