package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 프록시 패턴
// 공통관심사항들을 작성할 클래스
@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(public * com.ssafy.aop.*.coding())")
	public void mypt() {}
	
	// (1) Before
	// 핵심관심사항 실행 이전 Advice
	@Before("mypt()") // pointcut 명시
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}

	// (2) AfterReturning
	// 핵심관심사항 실행 이후1 Advice(예외 미발생)
	@AfterReturning("mypt()") // pointcut 명시
	public void afterReturning() {
		System.out.println("Git에 Push 한다.");
	}

	// Throwable Class
	// 자바에서 예외처리를 하기 위한 최상위 클래스
	// 모든 예외의 조상이 되는 Exception 클래스와
	// 모든 오류의 조상이 되는 Error 클래스의 부모 클래스

	// (2) AfterThrowing
	// 핵심관심사항 실행 이후2 Advice(예외 발생)
	@AfterThrowing(value = "mypt()", throwing = "th") // pointcut 명시, 예외 명시
	public void afterThrowing(Throwable th) {
		System.out.println("반차를 낸다.");

		// 만약 Throwable로 들어온 예외가 OuchException일 경우		
		// OuchException에 있는 메소드인 handleException()을 호출
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	// (3) After
	// 핵심관심사항 종료 Advice
	@After("mypt()") // pointcut 명시
	public void after() {
		System.out.println("하루를 마무리 한다.");
	}

	// (0) Around
	// 핵심관심사항 이전 이후 모두에서 동장하는 Advice
	// @Around("mypt()") // pointcut 명시
	public void around(ProceedingJoinPoint pjt) {
		// 이전
		this.before();

		// 이후
		try {
			pjt.proceed(); // pjt 실행
			this.afterReturning(); // 실행 이후(예외 미발생)
		} catch (Throwable e) {
			this.afterThrowing(e); // 실행 이후(예외 발생)
		} finally {
			this.after(); // 종료
		}

	}

}
