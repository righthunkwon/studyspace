package com.ssafy.prac5;

public class User {
	
	// 외부에서 객체 내부의 변수에 직접 접근하지 못하도록 접근 제한자 설정
	private String id;
	private String password;
	private String name;
	private String email;
	private int age;
	
	public User() {}

	public User(String id, String password, String name, String email, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	/*
	 * 멤버 변수 이름을 통해 직접 접근하는 대신
	 * getter / setter 메소드를 통해 접근할수 있도록 getter / setter 메소드들을 만들어주세요.
	 * 예) id값 가져오기 : getId() { .... / id값 설정하기 : setId(String id) { ...
	 */

	// getter & setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}

}
