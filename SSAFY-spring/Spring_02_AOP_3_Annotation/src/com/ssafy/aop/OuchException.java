package com.ssafy.aop;

public class OuchException extends RuntimeException{
	public void handleException() {
		System.out.println("병원에 간다.");
	}
}