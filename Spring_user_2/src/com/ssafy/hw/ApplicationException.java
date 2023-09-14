package com.ssafy.hw;

public class ApplicationException extends Exception {
	public void handleException() {
		System.out.println("애플리케이션에 문제가 생겨 점검합니다.");
	}
}
