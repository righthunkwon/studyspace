package com.multi.campus.dto;

import java.util.List;

public class BoardDTO {
	private int no;
	private String subject;
	private String content;
	private String userid;
	private String username;
	private int hit;
	private String writedate;
	private String ip;

	// 여러 개의 레코드를 한 번에 삭제할 때 필요한 레코드 번호
	private List<Integer> noList;
	
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", subject=" + subject + ", content=" + content + ", userid=" + userid
				+ ", username=" + username + ", hit=" + hit + ", writedate=" + writedate + ", ip=" + ip + ", noList="
				+ noList + "]";
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
	public List<Integer> getNoList() {
		return noList;
	}
	public void setNoList(List<Integer> noList) {
		this.noList = noList;
	}
}
