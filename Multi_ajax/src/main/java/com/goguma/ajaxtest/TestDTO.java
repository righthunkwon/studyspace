package com.goguma.ajaxtest;

public class TestDTO {
	private int no;
	private String subject;
	private String content;
	private String username;
	
	public TestDTO() {
		
	}
	
	public TestDTO(int no, String subject, String content, String username) {
		this.no = no;
		this.subject = subject;
		this.content = content;
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "TestDTO [no=" + no + ", subject=" + subject + ", content=" + content + ", username=" + username + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
