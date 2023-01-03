import java.util.Scanner;

public class Ex04Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력 :");
		int dan = scan.nextInt();
		
		// if~else 문 : 2~9 사이의 숫자인지 아닌지를 판단
		// for 문 : 구구단 구현
		
		if(dan>=2 && dan<=9) {
			for(int i=2; i<=9; i++) {
				int result = dan * i;
				System.out.println(dan + "*" + i + "=" + result);
			}
		} else {
			System.out.println("잘못 입력하였습니다.");
		}
				
	}

}
