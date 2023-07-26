package com.ssafy.prac8.user;

import java.util.Arrays;

public class UserTest {

	public static void main(String[] args) {
		User user1 = new User("user1", "user1pw", "김싸피", "ssafy1@ssafy.com", 27);
		User user2 = new User("user2", "user2pw", "박싸피", "ssafy2@ssafy.com", 28);
		VipUser vuser1 = new VipUser("vip1", "vip1pw", "금싸피" , "ssafy3@ssafy.com", 29, "Gold", 300);
		
		// 싱글톤 테스트를 위해 UserManager 2개 생성
		IUserManager um = UserManagerImpl.getInstance();
		
		um.add(user1);
		um.add(user2);
		um.add(vuser1);
		
		System.out.println(um.getList());
		System.out.println(um.getUsers());
		System.out.println(um.getVipUsers());
		System.out.println(um.searchByName("김"));
		System.out.println((int) um.getAgeAvg());
	}

}
