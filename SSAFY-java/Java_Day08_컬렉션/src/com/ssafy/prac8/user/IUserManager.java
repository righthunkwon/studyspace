package com.ssafy.prac8.user;

import java.util.List;

public interface IUserManager {
	void add(User user);
	
	List<User> getList();
	
	List<User> getUsers();
	
	List<User> getVipUsers();
	
	List<User> searchByName(String name);
	
	double getAgeAvg();
}
