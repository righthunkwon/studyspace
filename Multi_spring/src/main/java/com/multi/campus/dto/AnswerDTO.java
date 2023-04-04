package com.multi.campus.dto;

public class AnswerDTO {
	private int no;
	private String title;
	private String content;
	private String userid;
	private int hit;
	private String writedate;
	private String ip;
	private int ref; // 원글번호
	private int lvl; // 들여쓰기
	private int step; // 글순서
	
	@Override
	public String toString() {
		return "AnswerDTO [no=" + no + ", title=" + title + ", content=" + content + ", userid=" + userid + ", hit="
				+ hit + ", writedate=" + writedate + ", ip=" + ip + ", ref=" + ref + ", lvl=" + lvl + ", step=" + step
				+ "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
}
