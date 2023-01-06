import java.util.Scanner;

public class GuGuDanObject {
	public GuGuDanObject() {

	}

	// 단을 입력받는 메소드
	public int inputDan() {
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = scan.nextInt();
		return dan;
	}

	// 1개의 단을 처리하는 메소드
	public void oneDan(int dan) { // 상단의 dan과 해당 dan은 다른 변수이다.
		for (int i = 1; i <= 9; i++) {
			int result = dan * i;
			System.out.println(dan + " * " + i + " = " + result);
		}
	}

	// 전체단을 처리하는 메소드(2~9단)
	public void allDan() {
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println("=" + dan + "단=");
			oneDan(dan);
			
			/*
				상단의 oneDan(dan);으로 하단의 동일한 코드를 대체
				
				for(int i=1; i<=9; i++) { 
				int result = dan * i; 
				System.out.println(dan + " * " + i + " = " + result);
				}
			*/

		}
	}

}
