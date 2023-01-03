import java.util.Scanner;

public class Ex03Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int max = scan.nextInt();
		
		int sum = 0, oddSum = 0, evenSum = 0, triSum = 0;
		for(int i=1; i<=max; i++) {
			sum += i;
			if(i % 2 == 1) {
				oddSum += i;
			} else {
				evenSum += i;
			}
			if(i % 3 == 0) {
				triSum += i;
			}
		}
		System.out.println("1~" + max + "까지의 합은 " + sum);
		System.out.println("1~" + max + "까지의 홀수의 합은 " + oddSum);
		System.out.println("1~" + max + "까지의 짝수의 합은 " + evenSum);
		System.out.println("1~" + max + "까지의 3의 배수의 합은 " + triSum);
	}

}
