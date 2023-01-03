
public class Variable {
	// 멤버변수
	public static void main(String[] args) {
		// 지역변수
		
		// 클래스는 대문자로 시작한다(Variable).

		// 기본 데이터 형
		// 1. 정수(byte, short, int(기본), long)
		byte kor = 97;
		byte eng = (byte)130; // byte는 정수형이지만 8bit, 즉 -128부터 127까지만 값이 허용되므로 데이터형을 바꿔야 한다. 강제로 byte형으로 형변환을 하였다.
		
		// System : 클래스명, out : 변수, println : 메소드
		// "" -> 문자열, String (여러 문자, 하나도 가능)
		// '' -> 문자, char (단 하나의 문자)
		System.out.println("kor=" + kor);
		System.out.println("eng=" + eng);
		
		// 작은 데이터 타입의 정보를 큰 데이터 타입에 넣어줄 때는 자동 형변환이 일어난다. (큰 걸 작은 곳에 넣을 때 문제 발생!)
		int data = kor;
		System.out.println("data=" + data);
		
		// 숫자가 기본 데이터 타입인 int의 범위를 벗어날 경우 마지막에 L을 붙여 이를 int보다 더 큰 long형임을 나타내준다.
		long data2 = 9999999999L;
		System.out.println("data2=" + data2);
		
		// 2. 실수(float : 4byte, double(기본) : 8byte)
		double n1 = 15.3;
		float n2 = (float)15.3; // 자바의 실수 타입의 기본 처리는 double 타입이므로 이를 float로 형변환하여 사용한다.
		float n3 = 15.3F; // 형변환 없이 float 타입에 값을 저장하려면 실수 리터럴 뒤에 f 또는 F 를 붙이면 된다.
		
		// 실수 > 정수이므로 별도의 처리 없이 값을 넣으면 오류 발생
		int data3 = (int)n1; // 형변환을 통해 오류 수정
		System.out.println("data3=" + data3); // 하지만, 소수점은 절삭되어 출력
		
		
		// 3. 문자형(char, 한 글자를 저장) (vs 문자열 : 한 글자 이상)
		char c1 = 'A';
		String name = "AAA";
		
		c1++;
		System.out.println("c1=" + c1); // A에서 하나 증가하여 B로 출력(아스키코드가 증가)
		
		// 4. 논리(boolean : true, false)
		// 이후 별도로 다룰 예정 
		
		// 여러 가지 형의 계산(더 큰 형이 기준!)
		
		// 1. char + int = int
		// c1은 char타입이고 1은 int타입인데, char과 int 중에서는 int 더 크므로 이를 계산하면 int 타입인데, 이를 c1이라는 char에 넣으려고 하여 오류가 발생하였다.
		c1 = (char)(c1 + 1); 
		
		// 2. int + double = double
		// int result = data3 + n1; -> 오류 발생
		int result1 = (int)(data3 + n1);
		double result2 = data3 + n1;
		System.out.println(c1 + "," + result1);
		
		// 3. 문자는 고유 번호인 아스키 코드를 갖는다.
		char c2 = 'B'; // 아스키 코드 : 66
		char c3 = 'C'; // 아스키 코드 : 67
		int result3 = c2 + c3; // 66 + 67 = 133
		System.out.println("result3=" + result3);
	}

}
