package com.ssafy.di5;

// Computer라는 interface를 통해 
// Desktop과 Laptop을 사용(느슨한 결합)
public interface Computer {
	
	// interface의 메소드 앞에는 public abstract 생략
	String getInfo();
}
