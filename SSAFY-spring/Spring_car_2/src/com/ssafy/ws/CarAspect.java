package com.ssafy.ws;

public class CarAspect {
	
	public void before() {
		System.out.println("차를 탑니다.");
	}
	
	public void after_rt() {
		System.out.println("주차를 합니다.");
	}
	
	public void after_th(Throwable th) {
		if (th instanceof GasException) {
			((GasException) th).handleException();
		}
	}
	
	public void after() {
		System.out.println("차에서 내립니다.");
	}
}
