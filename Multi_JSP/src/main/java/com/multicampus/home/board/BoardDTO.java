package com.multicampus.home.board;

public class BoardDTO {

	private int no;
	private String subject;
	private String content;
	private String userid;
	private String username;
	private int hit;
	private String writedate;
	private String ip;
	
	// toString (for clients)
	@Override
	public String toString() {
		return "no=" + no + ", subject=" + subject + ", content=" + content + ", userid=" + userid + ", hit="
				+ hit + ", writedate=" + writedate + ", ip=" + ip;
	}
	
	// Getters and Setters 
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
