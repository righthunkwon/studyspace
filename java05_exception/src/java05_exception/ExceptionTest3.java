package java05_exception;

import java.util.Scanner;

public class ExceptionTest3 {

	public ExceptionTest3() {
	
	}
	
	// 문자열 입력받기
	// nextInt(); 	: nextInt();에 문자와 숫자를 교차하여 입력받으면 오류가 발생하기 쉽다.
	// nextLine();	: 문자와 숫자를 교차하여 입력받을 때는 nextLine();을 통해 문자를 입력받고, 필요할 경우 이를 숫자로 바꾸는 게 좀 더 오류 발생 가능성이 적다.
	public void inData() throws NumberFormatException, ArithmeticException, ArrayIndexOutOfBoundsException {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 수 : ");
		String n1 = scan.nextLine(); // 콘솔에 enter를 포함하여 한 줄씩 입력한다.
		System.out.print("두번째 수 : ");
		String n2 = scan.nextLine();
		int n1Int = Integer.parseInt(n1); // 문자열을 정수형 int로 변환해주는 메소드
		int n2Int = Integer.parseInt(n2);
		divide(n1Int, n2Int);
	}
	public void divide(int n1, int n2) throws ArithmeticException, ArrayIndexOutOfBoundsException {
		int result = n1 / n2; // <-------- ArithmeticException
		System.out.printf("%d / %d = %d\n", n1, n2, result);
		array();
	}
	public void array() throws ArrayIndexOutOfBoundsException {
		int[] data = {10, 20, 30};
		System.out.println(data[data.length]); // <-------- ArrayIndexOutOfBoundsException
	}
	
	public static void main(String[] args) {
		try {
			ExceptionTest3 et3 = new ExceptionTest3();
			et3.inData();
		} catch (NumberFormatException nfe) {
			System.out.println("입력값은 숫자여야 합니다.");
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException aioe) {
			System.out.println("배열의 범위를 초과한 데이터가 입력되었습니다");
		}
	}

}
