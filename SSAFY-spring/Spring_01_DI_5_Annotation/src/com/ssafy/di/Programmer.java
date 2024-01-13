package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
	// Annotation을 활용한 의존성 주입 방법: @Autowired
	// (1) 필드
	// (2) 생성자
	// (3) 설정자
	
	// 필드
	// 데스크탑과 랩탑 모두 @component로 설정했으므로
	// 이를 모두 포함하는 컴퓨터로 의존성을 주입할 경우 어느 클래스를
	// 빈으로 가져와야 할지 컴퓨터가 판단할 수 없기 때문에 에러가 발생한다.
	
	// 따라서 @Qualifier를 통해 해당 의존성 주입이
	// 어떤 빈 객체를 참고하는지 좀 더 유니크하게 알려줘야 한다.
	@Autowired
	@Qualifier("desktop")
	private Computer computer;
	
	// 기본 생성자
	// 생성자를 하나만 정의한다면 @Autowired를 생략할 수 있다.
	public Programmer() {
	}
			
	// 생성자
	@Autowired
	public Programmer(@Qualifier("desktop") Computer computer) {
		this.computer = computer;
	}
	
	// 설정자
	@Autowired
	public void setComputer(@Qualifier("desktop") Computer computer) {
		this.computer = computer;
	}
	
	// 메소드
	public void coding() {
		System.out.println(computer.getInfo() + "(으)로 개발한다.");
	}
	
}
