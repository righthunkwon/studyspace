import java.util.Scanner;

public class Ex04For {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
			2~9단까지
			
			[실행]
			단 입력 -> 10
			단을 잘못 입력하셨습니다.
			
			단 입력 -> 5
			5 * 2 = 10
			5 * 3 = 15
			:
			:
			5 * 9 = 45
		*/
		
		System.out.print("숫자 입력 : ");
		int num = scan.nextInt();
		int result = 0;
		
		for(int i = 2; i <= 9; i++) {
			System.out.println(num +"*" + i + "=" + (num * i));
		}
		
	}

}
