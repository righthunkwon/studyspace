package com.ssafy.fit.model.dto;

import java.util.Date;

public class Review {
	private static int no = 1;
	
	private int id;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	

	public Review() {
	}
	
	public Review(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		
		this.id = no++; // 클래스 변수 no를 활용하여 고유번호 등록
		this.regDate = new Date().toString(); // 현재 날짜 둥록
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}

