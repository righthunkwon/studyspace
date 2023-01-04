import java.util.Iterator;
import java.util.Scanner;

public class Ex06While {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * 양의 정수 : 10 
		 * 1~10까지의 합 : 55
		 * 계속하시겠습니까(1:yes, 2:no)? 1
		 *
		 * (...)
		 * 
		 * 양의 정수 = 100
		 * 1~100까지의 합 : 5050
		 * 계속하시겠습니까(1:yes, 2:no)? 2
		 * 프로그램이 좋료되었습니다.
		*/
		
		
		// 반복되는 조건을 설정할 때는 for 문 보다는 while 문을 더 자주 사용한다.
		
		while(true) { // true : 일단 한 번은 무조건 실행
		
		// num 까지의 합 구하기
		System.out.print("양의 정수 : ");
		int num = scan.nextInt();
		int sum = 0;
		
		for(int i=1; i<=num ; i++) {
			sum += i;
		}
		System.out.println("1~"+num+"까지의 합 : "+ sum);
		
		// 계속 여부(1: 계속, 나머지: 정지)
		System.out.print("계속하시겠습니까? (1: 예, 그외: 아니오)");
		int que = scan.nextInt();
		if(que!=1) {
			System.out.println("프로그램이 종료되었습니다.");
			break;
		}
		}
	}
}
