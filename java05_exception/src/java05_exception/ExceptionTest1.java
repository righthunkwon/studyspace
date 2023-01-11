package java05_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.tree.ExpandVetoException;

public class ExceptionTest1 {

	public ExceptionTest1() {
		
	}
	public void start() {
		
		/*
			예외처리코드
					(1) try { 예외 발생 가능 코드 }
					(2) catch(예외클래스 변수) { 예외처리 }
					(3) finally { 항상 실행; } -> 생략 가능
					
					try에서 예외가 발생하면 catch로 들어가 예외를 처리한 뒤 finally로 넘어가고, 
					예외가 발생하지 않으면 바로 fianlly 코드로 넘어가 실행한다.
		*/
		
		
		try { // try 영역 : 예외가 발생 가능한 코드를 기술(예외 없어도 기술 가능)
			
			// 두 수를 입력받아 합, 차, 곱, 몫을 구하는 프로그램을 작성하시오.
			Scanner scan = new Scanner(System.in);
			System.out.print("첫번째 수=");
			int num1 = scan.nextInt();
			System.out.print("두번째 수=");
			int num2 = scan.nextInt();
			
			int hap = num1 + num2;
			int cha = num1 - num2;
			int mul = num1 * num2;
			int div = num1 / num2;
			System.out.printf("%-5d + %-5d = %7.2f\n", num1, num2, (double)hap); // 5자리(+:오른쪽 정렬, -:왼쪽 정렬)
			System.out.printf("%d - %d = %d\n", num1, num2, cha);
			System.out.printf("%d * %d = %d\n", num1, num2, mul);
			System.out.printf("%d / %d = %d", num1, num2, div);
			
			int[] data = {10, 20, 30};
			System.out.println("배열 : "+ data[data.length-1]); 
			// data.length는 3인데, data는 index가 0~2로 있으므로 없는 값인 data[3]을 구하라고 하여 예외발생
			// 이 경우 data.length - 1 을 해주면 예외 처리 가능
			
		} catch(InputMismatchException ie) { // catch 영역(1) : try 영역에서 예외가 발생하면 catch 영역으로 이동
			System.out.println("정수를 입력하세요.");
			ie.printStackTrace();
			System.out.println(ie.getMessage());
		} catch(ArithmeticException ae) { // catch 영역(2)
			System.out.println("두번째 값은 0을 입력하지 마세요.");
			ae.printStackTrace();
			System.out.println(ae.getMessage());
		} catch(ArrayIndexOutOfBoundsException aioe) {
			aioe.printStackTrace();
			System.out.println(aioe.getMessage());
		} finally {
			System.out.println("예외가 발생하더라도 무조건 실행됨");
		}
	}
	public static void main(String[] args) {
		new ExceptionTest1().start();
	}

}
