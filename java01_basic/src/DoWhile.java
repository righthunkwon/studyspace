import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// do~while 문 : 한 번은 실행되는 반복문
		
		int n = 0;
		do {
			n += 1;
			System.out.println(n);
		} while(n<5);

		do {
			System.out.print("숫자 입력 :");
			int dan = scan.nextInt();
			
			if(dan>=2 && dan<=9) {
				for(int i=2; i<=9; i++) {
					int result = dan * i;
					System.out.println(dan + "*" + i + "=" + result);
				}
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}while(true); // 종료되지 않는 프로그램
		
		}
}
