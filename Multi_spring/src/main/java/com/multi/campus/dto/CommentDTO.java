package com.multi.campus.dto;

public class CommentDTO {
	private int c_no;
	private int no;
	private String c_comment;
	private String userid;
	private String writedate;
	private String ip;
	
	@Override
	public String toString() {
		return "CommentDTO [c_no=" + c_no + ", no=" + no + ", c_comment=" + c_comment + ", userid=" + userid
				+ ", writedate=" + writedate + ", ip=" + ip + "]";
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
