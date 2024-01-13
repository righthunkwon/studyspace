package com.ssafy.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
	private Computer computer;

	public Programmer() {
	}

	public Programmer(Computer computer) {
		this.computer = computer;
	}
	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 한다.");
	}
}
