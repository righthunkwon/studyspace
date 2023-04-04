package com.multi.campus.dto;

import java.util.Arrays;

public class RegisterDTO {
	private String userid;
	private String userpwd;
	private String username;
	
	private String tel;
	
	private String tel1;
	private String tel2;
	private String tel3;
	
	private String email;
	private String zipcode;
	private String addr;
	private String addrdetail;
	
	private String hobby; // ��ȭ/���/ ...
	private String[] hobbyArr;
	
	private String writedate;
	
	@Override
	public String toString() {
		return "RegisterDTO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", tel=" + tel
				+ ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", email=" + email + ", zipcode=" + zipcode
				+ ", addr=" + addr + ", addrdetail=" + addrdetail + ", hobby=" + hobby + ", hobbyArr="
				+ Arrays.toString(hobbyArr) + ", writedate=" + writedate + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		tel = tel1+"-"+tel2+"-"+tel3;
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
		
		// ��ȭ��ȣ�� -�� �������� split �� ����, tel1, tel2, tel3�� �����Ѵ�.
		String[] telCut = tel.split("-");
		tel1= telCut[0];
		tel2= telCut[1];
		tel3= telCut[2];
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrdetail() {
		return addrdetail;
	}
	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}
	public String getHobby() {
		// �迭�� ��̸� ���ڿ��� �ٲ� ��������
		String hobbyStr = Arrays.toString(hobbyArr); // [��ȭ, ���, �౸]
		hobbyStr = hobbyStr.substring(1, hobbyStr.length()-1); // ��ȭ, ���, �౸
		hobbyStr = hobbyStr.replaceAll(", ", "/"); // ��ȭ/���/�౸
		hobby = hobbyStr;
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
		hobbyArr = hobby.split("/"); // ���(hobby)�� ���ڿ����� �迭�� ��ȯ
	}
	public String[] getHobbyArr() {
		return hobbyArr;
	}
	public void setHobbyArr(String[] hobbyArr) {
		this.hobbyArr = hobbyArr;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
	
}
