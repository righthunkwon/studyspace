package com.ssafy.hw;

import java.util.Random;

public class AdminUser implements User {

	@Override
	public void useApp() throws ApplicationException {
		System.out.println("애플리케이션을 관리합니다.");

		// 확률적 예외 발생
		if (new Random().nextBoolean()) {
			throw new ApplicationException();
		}
	}

}
