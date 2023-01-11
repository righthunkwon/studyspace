package java05_exception;

	/*
		사용자 정의 예외 클래스 생성 규칙
		
			(1) 클래스명은 Exception을 마지막 단어로 합성한다.
			(2) api의 Exception 클래스 또는 Runtime Exception 클래스 중 1개를 상속받는다.
	*/

public class MyException extends Exception {
	public MyException() {
		// 상위클래스 Exception(String)을 호출하여 예외 메시지를 세팅
		super("1~100사이의 값이 아닙니다.");
	}
	public MyException(String message) {
		super(message);
	}
}
