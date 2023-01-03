import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// if 문 : true일 경우 실행
		// 임의의 수를 입력받아 양수면 100을 곱하여 출력하라.
		System.out.print("정수입력=");
		int n = scan.nextInt();
		
		if(n>0) {
			int result = n * 100;
			System.out.println(n + "*100=" + result);
		}
		System.out.println("The End");
		
		/*
			System.out.println(n); 오류 발생 X
			System.out.println(result); 오류 발생 O
			
			n이라는 변수는 메인 메소드 안에서 선언되었므로 메인 메소드가 끝나기 전까지 유지되지만,
			result라는 변수는 if 문 안에서 선언되었으므로 if 문이 끝나면 유지되지 않기에 오류가 발생한다.
			이러한 result와 같은 변수는 지역변수라 한다.
			만약, if 문 밖에 int result=0;과 같이 초기값을 선언하면 result를 메인 메소드에서 출력해도 오류가 나지 않는다.
		*/

	}

}
