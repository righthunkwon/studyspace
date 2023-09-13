package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		// xml 설정파일을 통해 스프링 컨텍스트 로드
		ApplicationContext appCtx = new GenericXmlApplicationContext("applicationContext.xml");

		// User의 정보를 출력하는 기능을 가진 객체 가져오기
		UserPrinter printer = appCtx.getBean(UserPrinter.class);

		// // User정보 출력, 의존성 주입 잘 되었는지 확인
		System.out.println("************1. 의존성 주입");
		printer.printUserRank();

		// User객체 두번 가져온 후 같은 객체를 참조하는지 비교
		System.out.println("************2. 싱글톤 확인");
		User user1 = appCtx.getBean(VipUser.class);
		User user2 = appCtx.getBean(VipUser.class);
		System.out.println(user1 == user2);

	}
}
