package com.ssafit.board.model.dto;

public class User {
	private String userId;
	private String password;
	private String name;
	private String nickname;
	private String birthdate;
	public User() {
		
	}
	public User(String userId, String password, String name, String nickname, String birthdate) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birthdate = birthdate;
	}
	public User(String userId, String password, String name, String nickname) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", birthdate=" + birthdate + "]";
	}
	
}
