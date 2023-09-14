package com.ssafy.proxy;

public class Ssafy implements Person {

	// 싸피인의 일상
	// 핵심관심사항을 제외하고는 모두 삭제
	// 나머지 관심사항은 Proxy를 통해 관리
	@Override
	public void coding() {
		System.out.println("열심히 공부를 한다."); // 핵심관심사항(기준)
	}
}
