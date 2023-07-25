package src.java01.intro;

public class Intro03_PrintTest {
	public static void main(String[] args) {
		// print (줄바꿈 X)
		System.out.print("Hello World");
		
		// println (줄바꿈 O, ln = line)
		System.out.println("Hello World!!!");
		System.out.println("Hello World!!!");

		// 이스케이프 코드(\뒤의 문자를 문자 그대로로 인식)
		System.out.println("\\");
		System.out.println("\"");
		
		// printf (형식, format)
		// \n : 줄바뀜
		System.out.printf("%d \n", 10); // 정수 (10진수, 0~9까지 활용)
		System.out.printf("%o \n", 10); // 정수 (8진수, 0~7까지 활용, 8진수의 12는 10진수의 10)
		System.out.printf("%x \n", 10); // 정수 (16진수, 0~15까지 활용, 0123456789ABCDE)
		System.out.printf("%X \n", 10); // 정수 (16진수, 0~15까지 활용, 0123456789ABCDE)

		System.out.printf("%4d\n", 10); // 4칸을 확보한 뒤 오른쪽부터 차지
		System.out.printf("%-4d\n", 10); // 4칸을 확보한 뒤 왼쪽부터 차지
		System.out.printf("%04d\n", 10); // 4칸을 확보한 뒤 오른쪽부터 차지(빈칸에 0을 채운다.)

		System.out.printf("%f\n", 10.1); // 실수 (float의 기본값은 소수점 여섯자리까지 출력)
		System.out.printf("%.2f\n", 10.1); // 실수 (소수점 둘째자리까지)
		System.out.printf("%.2f\n", 10.105); // 실수 (소수점 둘째자리까지, 셋째자리에서 반올림 적용)

		System.out.printf("%s\n", "양명균"); // 문자열
		System.out.printf("%c\n", 'o'); // 문자

	}
}
