import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String addr1 = "서울시 강남구";
		String addr2 = "서울시 강남구";
		String addr3 = new String("서울시 강남구");
		
		// 변수는 다르지만 내부의 값이 같으면 같다.
		if(addr1 == addr2) {
			System.out.println("addr1과 add2는 같다.");
		} else {
			System.out.println("addr1과 add2는 다르다.");
		}
		
		/* 
			case 1) addr1, addr2
		
					stack 에 저장된 값 : addr1 = "서울시 강남구", addr2 = "서울시 강남구";
					heap에 저장된 값 : 없음
					
			case 2) addr3
			
					stack 에 저장된 값 : addr3 = 주소값
					heap에 저장된 값 : "서울시 강남구"
					
					따라서, 객체에 있는 데이터는 메소드를 이용하여 비교해야 한다.
		*/
		
		// 일반적인 비교 결과
		if(addr2 == addr3) {
			System.out.println("addr2과 add3는 같다.");
		} else {
			System.out.println("addr2과 add3는 다르다.");
		}
		
		// equals 메소드를 활용한 비교 결과
		if(addr2.equals(addr3)) {
			System.out.println("addr2과 add3는 같다.");
		} else {
			System.out.println("addr2과 add3는 다르다.");
		}
		
		
		// 문자와 관련한 클래스 : String
		// 문자열을 처리하는 String 클래스에 위치한 메소드 중 자주 쓰이는 몇 가지를 배워보자.
		//			  012345678901234567890	글자에 인덱스 부여(공백 포함)
		
		String str1 = "Java programming test";
		String str2 = "java String Test";

		// 특정 index 위치의 문자를 얻어오기 : .charAt()
		char r1 = str1.charAt(5);
		System.out.println("r1="+r1);
		
		
		// str1과 str2를 비교하는 메소드(대소문자 구별 O) : .compareTo()
		// str1-str2를 계산하여 값의 차이를 구한다. (str1 > str2 이면 결과가 양수이고, str2 > str1이면 결과가 음수이다).
		// 비교는 동일하지 않은 문자가 처음으로 나올 때까지 찾은 뒤 해당 문자가 나오면 그 문자를 비교한다.
		// 아스키 코드 : J=74, j=106
		int r2 = str1.compareTo(str2);
		System.out.println("r2="+r2);
		
		// str1과 str2를 비교하는 메소드(대소문자 구별 X) : .compareToIgnoreCase()
		int r3 = str1.compareToIgnoreCase(str2);
		System.out.println("r3="+r3); // p q r s 이므로 -3
		
		
		// 문자열 연결 : .concat() (순서 존재)
		String r4 = str1.concat(str2);
		System.out.println("r4="+r4);
		
		String r5 = str2.concat(str1);
		System.out.println("r5="+r5);
		
		
		// 바이트 코드 구하기 : .getBytes()
		byte[] r6 = str1.getBytes();
		System.out.println("r6="+Arrays.toString(r6));
		
		
		// 가장 먼저 만나는 문자의 index 구하기 : .indexOf()
		// String str1 = "Java programming test";
		// String str2 = "java String Test";
		
		int r7 = str1.indexOf("v");
		System.out.println("r7="+r7);
		
		int r8 = str1.indexOf("x");
		System.out.println("r8="+r8); // 문자가 없을 경우 -1 출력
		
		// 마지막 문자의 index 구하기 : .lastIndexOf()
		int r9 = str1.lastIndexOf("a");
		System.out.println("r9="+r9);
		
	
		// 원하는 위치부터 index 구하기 : .indexOf(찾는 문자, 찾기를 시작할 위치)
		int r10 = str1.indexOf("a", 4);
		System.out.println("r10="+r10);
				
		
		// 문자열 대체하기 : .replace(바꿀 문자, 바뀔 문자)
		String r11 = str1.replace("Java", "자바");
		System.out.println("r11="+r11);
		

		
		// 문자열 조각내기 : .split()
		
		/*
		전화번호는 입력받을 때 사용자는 010 / 1234 / 5678로 입력하지만 DB에는 010 1234 5678로 연결되어 저장된다.
		하지만 사용자가 정보를 수정해야 할 경우 이어진 값인 010 1234 5678를 010 / 1234 / 5678로 조각낼 필요가 있다.
		*/
		
		String tel = "010-1234-5678";
		String telSplit1[] = tel.split("-");
		System.out.println("telSplit1="+Arrays.toString(telSplit1));
		
		
		// 문자열의 일부 데이터 얻어오기 : .subString(시작 index, 끝 index) (단, 끝 index는 생략 가능하고 미만의 개념이다.)
		//		  		  012345678901234567890	
		// String str1 = "Java programming test";
		// String str2 = "java String Test";
		String r12 = str1.substring(14);
		System.out.println("r12="+r12);
		
		String r13 = str1.substring(5, 12);
		System.out.println("r13="+r13);
		
		
		// 양 사이드의 여백 없애기 : .trim()
		
		/*
			사용자가 회원가입을 할 때 가령 첫 글자에 공백을 실수로 집어 넣고 회원가입을 한다면 계정을 찾기 정말 어려울 것이다.
			이러한 상황에서 .trim을 활용하면 사용자의 실수를 예방할 수 있다.
		*/
		
		String str3 = "     .trim 테스트     ";
		System.out.println("===="+str3+"====");
		System.out.println("===="+str3.trim()+"====");
		
		
		// 정수,실수,논리값,char배열을 문자열로 반환기 : .valueOf()
		char[] c = {'J','A','V','A'};
		System.out.println(c);
		String r14 = String.valueOf(c);
		System.out.println("r14="+r14);
	
		
		// 문자열의 크기비교 : StringA.compareTo(StringB) -> StringB - StringA -> 결과가 양수면 왼쪽(A)가 크고, 결과가 음수면 오른쪽(B)가 크다.
		String str4 = "Oracle"; // O : 79(아스키코드)
		String str5 = "oracle"; // o : 111
		
		int result = str4.compareTo(str5); // 순서는 왼쪽 - 오른쪽 (str5 - str4)
		System.out.println("str4와 str5의 비교 : "+result); // -32
	}	

}
