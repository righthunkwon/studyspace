package com.ssafy.di2;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
	// 필드 (생략) CPU, 그래픽카드, 키보드 ....
	public String getInfo() {
		return "데스크톱";
	}
}
