package com.ssafy.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPrinter {
	
	/*
	 * User 정보를 출력하기 위해 User 객체가 필요합니다. 
	 * 이 경우 User 객체에 의존하고 있다고 할 수 있습니다. 
	 * Spring에서 제공하는 여러가지 기능을 이용해서 User객체를 주입받고,(의존성 주입) 
	 * 주입받은 User 정보를 출력할 수 있도록 해봅시다.
	 */

	@Autowired
	// 의존성 주입은 필드, 생성자, 설정자에 가능!
	User user; // 필드

	// Spring에서 주입받은 User 정보 출력하기
	public void printUserRank() {
		System.out.println("I'm " + user.getRank() + "user.");
	}

}
