
public class FinalTestMain {
	// fianl : 상수, 변하지 않는 값, 대문자로 선언
	final String COMPANY = "멀티캠퍼스"; 
	private final String ADDRESS;
	static final String PHONE = "010-1234-5678";
	
	public FinalTestMain() {
		ADDRESS = "서울시 강남구";
		// ADDRESS = "서울시 영등포구"; final 이하는 값을 변경할 수 없기에 오류 발생.
	}
	public void information() {
		System.out.println("회사명 : "+ COMPANY);
		System.out.println("주소 : "+ ADDRESS);
	}

}
