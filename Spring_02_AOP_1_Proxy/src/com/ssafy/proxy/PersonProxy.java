package com.ssafy.proxy;

import java.util.Random;

import com.ssafy.no.proxy.OuchException;

// 프록시 패턴
// 어떤 객체를 사용 할 때, 해당 객체를 직접 참조하는 것이 아닌 
// 해당 객체를 참조하는 객체를 통해 대상 객체에 접근하는 방식을 사용하면
// 해당 객체가 메모리에 존재하지 않아도 기본적인 정보를 참조하거나 설정할 수 있고, 
// 실제 객체의 기능이 필요한 시점까지 객체의 생성을 미룰 수 있다.
public class PersonProxy implements Person {

	// 의존성 주입 방법
	// 필드, 생성자, 설정자
	
	private Person person;

	// 느슨한 결합
	// Person에는 프로그래머가 올 수 도 있고, 싸피인이 올 수도 있다.
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 이전에 해야할 일
		try {
			person.coding(); // 핵심관심사항(기준)
			if (new Random().nextBoolean())
				throw new OuchException();
			System.out.println("Git에 Push 한다."); // 이상 없이 마무리가 되었을 때.
		} catch (OuchException e) {
			System.out.println("반차를 낸다."); // 예외 발생
		} finally {
			System.out.println("보람찬 하루를 마무리한다."); // 모든 게 마무리가 되었을 때.
		}
	}

}
