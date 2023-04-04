package java05_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest () {
		
	}
	
	// 임의의 정수를 입력받아 그 수까지 합을 구하는 기능
	public void start() {
		try {
			System.out.print("정수=");
			int max = scan.nextInt();
			
			// 1~100 사이의 값이 아니면 예외 발생시키기
			if(max>=1 && max <=100) {
				// 제대로 된 값이 들어왔을 때는 정상적으로 코드 실행
				int tot = sum(max);
				System.out.println("1~"+max+"까지의 합은 "+tot);
			// 잘못된 값이 들어 왔을 때는 예외 발생시킴, throw 활용
			} else { 
				throw new MyException();
			}
		} catch (InputMismatchException ime) {
			System.out.println("정수를 입력하지 않았습니다.");
		} catch (MyException me) {
			System.out.println(me.getMessage());
			// getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메세지를 얻게 해주는 메서드
		}
	}

	
	// 합 구하기
	public int sum(int max) {
		int sum = 0;
		for(int i=1; i<=max; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		MyExceptionTest met = new MyExceptionTest();
		met.start();
		
	}

}
