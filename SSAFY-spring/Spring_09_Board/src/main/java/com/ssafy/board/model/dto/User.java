package com.ssafy.board.model.dto;

public class User {
	private String id; // users 테이블의 컬럼
	private String password; // users 테이블의 컬럼
	private String name; // users 테이블의 컬럼
	private int curriculumCode; // users 테이블의 컬럼 & curriculum 테이블의 컬럼
	private String curriculumName; // curriculum 테이블의 컬럼

	public User() {
	}

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

	public int getCurriculumCode() {
		return curriculumCode;
	}

	public void setCurriculumCode(int curriculumCode) {
		this.curriculumCode = curriculumCode;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", curriculumCode=" + curriculumCode
				+ ", curriculumName=" + curriculumName + "]";
	}

}
