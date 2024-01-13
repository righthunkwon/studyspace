package exception02_throws;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
	public void methodA() throws IOException {
		
	}
	
	public void methodB() throws ClassNotFoundException {
		
	}
}

public class ThrowTest03_Override extends Parent {
	
	@Override
	public void methodA() throws FileNotFoundException {

	}

	// 예외 발생
	// 부모가 던지는 예외보다 더 큰 예외를 자식이 던질 수 없다.
	
//	@Override
//	public void methodB() throws Exception {
//
//	}

	public static void main(String[] args) {
		
	}
}
