package test01.control;

import java.util.Scanner;

public class NumberMarchesSol {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sign;
		
		do {
			int compute = (int)(Math.random()*(99-10+1)+10); // 난수생성(10~99)
			int count = 0;
			do {
				System.out.print("숫자입력=");
				int userInput = Integer.parseInt(scan.nextLine());
				count++;
				if(compute > userInput) {
					System.out.println("컴퓨터의 수가 더 큽니다.");
				} else if (compute < userInput) {
					System.out.println("컴퓨터의 수가 더 작습니다");
				} else {
					System.out.println("축하합니다."+count+"번만에 맞췄습니다.");
					break;
				}
			} while(true); // compute 변수의 값을 맞출 때까지 반복
			System.out.print("계속하시겠습니까(Y/y)?");
			sign = scan.nextLine();
		// 방법 1 equalsIgnoreCase : 대소문자 구별 X
		} while(sign.equalsIgnoreCase("y"));
 		// 방법 2 equals : 대소문자 구별 O, while(sign.equals("Y") || sign.equals("y")); 
		// 방법 3 while(sign == "Y" || sign == "y");
	}

}

	/*
		Math.random
				
				Math.random() 함수는 double 형으로 0.0이상 1.0 미만 사이의 값을 반환하는 함수이다.
			  	난수를 만들고 싶을 때 자주 이용되며, 일반적으로 Math.random() * 숫자의 형태도 많이 사용된다.

				Math.random()을 간단하게 X라고 하면, 부등식을 이용해서 자신이 원하는 범위의 수를 표현할 수 있다. 
				
				0.0 <= X < 1.0 일 때,
				가령, 1과 10 미만의 '실수'를 생성하고 싶다면,
				0.0 * 9 + 1 <= X * 9 + 1 < 1.0 * 9 + 1 로 처리할 수 있다.

			 	만약 10과 100 미만의 '정수'를 생성하고 싶다면, 형변환을 섞어주면 된다.
				(int)(0.0 * 90) + 10 <= (int)(X * 90) + 10 < (int)(10.0 * 90) + 10
				
				
					(int)(Math.random()*(99-10+1)+10) 	-->	  10이상 99이하의 난수 생성
					
	*/
