package com.ssafy.prac10.user;

public class NameNotFoundException extends Exception {
	
	private String name;
	
	public NameNotFoundException(String name) {
		// 예외 발생시 콘솔에 출력될 메시지 작성
		super(name + " 이름을 포함하는 사용자가 존재하지 않습니다.");
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
