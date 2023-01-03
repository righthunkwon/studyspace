
public class Operator {

	public static void main(String[] args) {
		// Operator : 연산자
		
		// 산술연산자 (+, =, *, /, %) 
		// 부호 (+, -)
		
		// 대입연산자 
		int n1 = 1230;
		n1 *= 2; // n1 = n1 * 2; 와 동일한 결과
		System.out.println("n1=" + n1); // 2460
		
		// 증감연산자 : ++, --
		char c = 'A';
		c++; // B
		c++; // C
		c--; // B
		System.out.println("c->" + c); // B
		
		int n = 5;
		int result = n++ + 10;
		System.out.println("n=" + n + ", result="+ result); // n=6, result=15
	
		// 연산자 우선순위
		int result2 = 6 + 2 * 8 / (2 % 7 + 2 - 3) * 3;
		System.out.println("result2=" + result2);
		
		// 문자열 + 숫자형 = 문자열
		String str1 = "JDK" + 11.0;
		String str2 = str1 + "의 특징";
		System.out.println("str1=" + str1);
		System.out.println("str2=" + str2);
		
		String str3 = "JDk" + 10 + 1;
		String str4 = 10 + 1 + "JDK";
		System.out.println("str3=" + str3);
		System.out.println("str4=" + str4);
		
		// 비트 연산자 (2진수로 계산하기)(&, |, ^(XOR). ~)
		// 두 수의 자리를 맞춰서 비교하면서 판단
		// 0: false, 1: true
		
		// & : 논리곱(and), 두 비트가 모두 1일 경우에만 1
		int a = 10; // 0 0 0 0 1 0 1 0 
		int b = 3;  // 0 0 0 0 0 0 1 1
		int r1 = a & b; 
		System.out.println("r1=" + r1);
		
		// | : 논리합(or), 두 비트 중 하나만 1이어도 1
		int r2 = a | b;
		System.out.println("r2=" + r2);
		
		// ^ : 배타적 논리합(xor), 두 비트중 하나는 1이고 다른 하나가 0일 경우 1(다르면 1)
		int r3 = a ^ b;
		System.out.println("r3=" + r3);
		
		// ~ : 논리부정(not), 0은 1로, 1은 0으로 바꿈 [다시 살펴보기]
		// 2의 보수 : 1의 보수 + 1
		// 1의 보수 : 0은 1로, 1은 0으로
		
		System.out.println("~a=" + ~a);
		System.out.println("~b=" + ~b);
		
		// shift 연산자 : 비트를 왼쪽 또는 오른쪽으로 이동하며 연산하기(<<, >>, >>>)
		// << : 왼쪽으로 이동
		// >> : 오른쪽으로 이동, 빈 칸은 원래 부호로 채워짐
		// >>> : 오른쪽으로 이동, 빈 칸은 0으로 채워짐
		
		// int a = 10; , int b = 3;
		
		int r4 = a << 3;
		System.out.println("r5=" + r4); // 10 * 2^3
		/*
			a 	   : 0 0 0 0 1 0 1 0
			a << 3 : 0 1 0 1 0 0 0 0 
		*/
		
		int r5 = a >> 3;
		System.out.println("r6=" + r5);
		/*
			a 	   : 0 0 0 0 1 0 1 0
			a >> 3 : 0 0 0 0 0 0 0 1 / 넘어가버린 0 1 0 은 절삭
		*/
		
		int r6 = ~b >> 3;
		System.out.println("r6=" + r6);
		
		int r7 = ~b >>> 3;
		System.out.println("r7=" + r7);
		
		/*
			~b       : 
			~b >> 3  :
			~b >>> 3 :
		*/
	}

}
