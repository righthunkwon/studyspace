package java05_exception;

import java.util.Scanner;

public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest2() {
		
	}
	public void start() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("첫번째 수="); // <-------- InputMismatch (발생 가능한 예외)
			int num1 = scan.nextInt();
			System.out.print("두번째 수="); // <-------- InputMismatch
			int num2 = scan.nextInt();
			
			int hap = num1 + num2;
			int cha = num1 - num2;
			int mul = num1 * num2;
			int div = num1 / num2;
			System.out.printf("%d + %d = %d\n", num1, num2, hap);
			System.out.printf("%d - %d = %d\n", num1, num2, cha);
			System.out.printf("%d * %d = %d\n", num1, num2, mul);
			System.out.printf("%d / %d = %d\n", num1, num2, div); // <-------- Arithmentic
			
			int[] data = {10, 20, 30};
			System.out.println("배열 : "+ data[data.length]); // <-------- ArrayIndexOutOfBounds
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 index가 잘못 처리 되었습니다.");
		} catch(Exception e) { 	// 모든 예외 클래스는 Exception을 상속받는다.
								// 또한, 하위클래스는 상위클래스에 대입가능하다.
			System.out.println("입력값은 정수를 입력하고, 두번째 값은 0을 제외합니다.");
		}
	}
	public static void main(String[] args) {
		ExceptionTest2 et2 = new ExceptionTest2();
		et2.start();
	}

}
