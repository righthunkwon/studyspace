// 패키지(없거나 하나) - import(없거나 여러 개) - class 

package com.multi;

import java.lang.System;;

	/*
		접근 제한자 : public > protected > default(생략하면 기본값) > private
		
			public 		: 공용 (클래스, 필드, 생성자, 메소드에 사용)
			protected 	: 자식 클래스가 아닌 다른 패키지에 소속된 클래스에 접근 불가 (필드, 생성자, 메소드에 사용)
			default 	: 같은 패키지 내애서만 허용 (클래스, 필드, 생성자, 메소드에 사용)
			private 	: 모든 외부 클래스에서 접근 불가 (필드, 생성자, 메소드에 사용)
	*/

public class Student { // 클래스, 만약에 접근제한자 public을 생략할 경우 기본값인 default로 설정되어 다른 패키지에 소속된 클래스인 ModifierTest01은 Student 클래스를 사용할 수 없다.
	int num = 1;
	public String name = "권정훈";
	int ban = 7;
	
	public Student() { // 메서드
		
	}
	public void studentPrint() {
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("반 : " + ban);
	}
}
