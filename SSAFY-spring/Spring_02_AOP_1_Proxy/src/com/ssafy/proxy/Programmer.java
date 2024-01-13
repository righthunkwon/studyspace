package com.ssafy.proxy;

public class Programmer implements Person {

	// 프로그래머의 일상
	// 핵심관심사항을 제외하고는 모두 삭제
	// 나머지 관심사항은 Proxy를 통해 관리
	public void coding() {
		System.out.println("열심히 코드를 작성한다."); // 핵심관심사항(기준)
	}
}
