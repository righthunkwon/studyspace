import java.util.Scanner;

public class IfElseTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// if~else 문 : true면 if이하를, false면 else이하를 실행	
		// 임의의 정수를 입력받아 0 이상이면 100을 곱하여 출력하고, 0 미만이면 양수로 만든 후 200을 곱하여 출력하라.
		System.out.print("정수 입력=");
		int intData = scan.nextInt();
		int result;
		if(intData >= 0) {
			result = intData * 100;
		} else {
			result = -intData * 200;
		}
		System.out.println("result=" + result);
	}
}
