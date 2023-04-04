package com.multi.campus;

public class TestDTO {
	private int num;
	private String name;
	
	
	@Override
	public String toString() {
		return "TestDTO [num=" + num + ", name=" + name + "]";
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
