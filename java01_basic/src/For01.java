
public class For01 {

	public static void main(String[] args) {

		// 제어문자 : \
		// \n : 줄바꿈
		// \t : 여덟 칸 간격 띄어쓰기
		// \" : " 입력
		// \' : ' 입력
		System.out.println("1\n2\n3\n4\n5"); // \n : 개행
		System.out.println("1\t2\t3\t4\t5"); // \t : tap(8칸)
		System.out.println("저는 \'홍길동\'입니다."); // \", \' : 문자 그대로 입력
		
		// for 문 : 지정한 회전수 만큼 반복하는 반복문(초기화식, 조건식, 증감식)
		// 만약 조건이 성립하지 않는다면 for 문은 실행되지 않고 넘어간다.
		// 조건식(범위)가 지정되지 않는다면 무한루프에 빠져 코드가 계속 실행된다.
		// 증감식이 지정되지 않아도 무한루프에 빠져 초기값이 계속 실행된다.
		// i++의 다른 표현 : ++i, i=i+1, i+=1
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		// 반복문 활용 : 1~10까지의 홀수의 합
		int oddSum = 0;
		for(int i=1; i<=10; i+=2) {
			oddSum = oddSum + i;
		}
		System.out.println("홀수의 합=" + oddSum);
		System.out.println("====================================");
		
		// 반복문 활용 : A~Z까지 타이핑
		for(char alp='A'; alp<='Z'; alp++) {
			System.out.print(alp);
		}
		System.out.println(); // 줄바꿈

		// 반복문 활용 : A~Z까지 타이핑(아스키코드 활용)
		for(int i=65; i<=90; i++) {
			System.out.print((char)i);
		}
	}

}
