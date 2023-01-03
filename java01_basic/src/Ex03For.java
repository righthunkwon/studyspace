import java.util.Scanner;

public class Ex03For {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
			[실행]
			조건 : 1~n까지
			1~n까지의 합 :
			1~n까지의 홀수의 합 :
			1~n까지의 짝수의 합 :
			1~n까지의 3의 배수의 합 :
			
			test case
			1~9까지의 합 : 45
			1~9까지의 홀수의 합 : 25
			1~9까지의 짝수의 합 : 20
			1~9까지의 3의 배수의 합 : 18
		*/
		
		// 1~n까지의 합
		System.out.print("숫자 입력 : ");
		int num = scan.nextInt();
		
		int nSum = 0;
		for(int i = 1; i <=  num; i++) {
			nSum = nSum + i;
		}
		System.out.println("1~n까지의 합 : " + nSum);
		
		
		// 1~n까지의 홀수의 합		
		int oddSum = 0;
		for(int i = 1; i <=  num; i+=2) {
			oddSum = oddSum + i;
		}
		System.out.println("1~n까지의 홀수의 합 : " + oddSum);
		
		
		// 1~n까지의 짝수의 합		
		int evenSum = 0;
		for(int i = 1; i <=  num; i++) {
			if(i % 2 == 0) {
			evenSum = evenSum + i;
			}
		}
		System.out.println("1~n까지의 짝수의 합 : " + evenSum);
		
		
		// 1~n까지의 3의 배수의 합		
		int triSum = 0;
		for(int i = 1; i <=  num; i++) {
			if(i % 3 == 0) {
			triSum = triSum + i;
			}
		}
		System.out.println("1~n까지의 3의 배수의 합 : " + triSum);
	}

}
