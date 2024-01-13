package com.ssafy.prac8.user;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.prac8.movie.Movie;

public class UserManagerImpl implements IUserManager {
	
	List<User> userList = new ArrayList<User>();
	private final int MAX_SIZE = 100;

	// 싱글톤 패턴을 위한 객체 생성, 알맞은 접근 제어자 설정
	private static UserManagerImpl um = new UserManagerImpl();

	// 싱글톤 패턴의 기본 생성자, 객체 생성을 외부에서 하지 못하게 막음
	private UserManagerImpl() {
	}

	// 외부에서 사용할 수 있도록 UserManagerImpl 인스턴스 반환
	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (userList.size() < MAX_SIZE) {
			userList.add(user);
		} else if (userList.size() == MAX_SIZE) {
			System.out.println("유저는 100명 까지만 등록할 수 있습니다.");
		}
	}

	public List<User> getList() {
		return userList;
	}

	public List<User> getUsers() {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	public List<User> getVipUsers() {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof VipUser) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	public List<User> searchByName(String name) {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if ((userList.get(i)).getName().contains(name)) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	public double getAgeAvg() {
		int sum = 0;
		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}
		return sum / (double) userList.size();

	}

}
