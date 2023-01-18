package test01.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
		[개념]
		평년 : 2월에 29일이 추가되어 1년이 366일인 연도
		윤년 : 2월 28일, 1년 365일
		
		규칙 : 4으로 나누어 떨어지는 해는 윤년, 그 밖의 해는 평년
			  단, 100으로 나누어 떨어지는 해는 평년
			  단, 100으로 나누어 떨어지되, 400으로 나누어 떨어지지 않는 해는 평년
			  (ex. 1900년: 평년, 2000년: 윤년)
		
		[처리조건]
		연도를 입력받아 윤년과 평년을 구별하여 출력하라.
		첫번째 입력은 입력받을 연도의 갯수이다.
		(단, Scanner, Calendar api를 사용하지 말 것)
		
		[입력]
		6
		4 100 400 2000 2001 2004
		
		[출력]
		#1 윤년
		#2 평년
		#3 윤년
		#4 윤년
		#5 평년
		#6 윤년
	*/

public class CommonLeap {
	
	static void StartCommonLeap() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int cnt = Integer.parseInt(br.readLine());
			// 연도 입력
			String[] y = br.readLine().split(" ");
			String[] re = new String[cnt]; //
			
			// 윤년과 평년
			for(int i=0; i<y.length; i++) {
				int year = Integer.parseInt(y[i]);
				if(year%4==0 && year%100!=0 || year%400==0) { // 윤년
					re[i]="윤년";
				} else { // 평년
					re[i]="평년";
				}
			}
			print(re);
		} catch (Exception e) {
		}
	}
	static void print(String[] re) {
		for(int i=0; i<re.length; i++) {
			System.out.printf("#%d %s\n", i+1, re[i]);
		}
	}
	public static void main(String[] args) {
		StartCommonLeap();
	}

}

	/*
		사용자 입력을 받는 두 가지 방법
			
				(1) Scanner			: .next()
				(2) BufferedReader  : .read()
	*/
