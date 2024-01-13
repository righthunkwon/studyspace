package com.ssafy.prac10.user;

import java.util.List;

public interface IUserManager {
	void add(User user);
	
	List<User> getList();
	
	List<User> getUsers();
	
	List<User> getVipUsers();
	
	List<User> searchByName(String name) throws NameNotFoundException ;
	
	double getAgeAvg();
	
	void saveData();
	
	void loadData();
}
