package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

public class PersonManager {
	private List<Person> list = new ArrayList<>();
	
	// Singleton Pattern
	private static PersonManager pm = new PersonManager();
	private PersonManager() {
		
	}
	
	public static PersonManager getInstance()	{
		return pm;
	}
	
	public void regist(Person p) {
		list.add(p);
	}
	
	
	public List<Person> getAll(){
		return list;
	}
}