package com.ssafy.mvc.model.dto;

public class User {
	private String id;
	private String pw;
	private int age;

	public User() {
	}

	public User(String id, String pw, int age) {
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}

}
