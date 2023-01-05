
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
		
	}

}
