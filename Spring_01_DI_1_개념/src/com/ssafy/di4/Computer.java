package com.ssafy.di4;

// Computer라는 interface를 통해 
// Desktop과 Laptop을 사용(느슨한 결합)
public interface Computer {
	
	// public abstract 생략
	String getInfo();
}
