
public class FinalTest {
	
	public FinalTest() {
		
	}	
	public void start() {
		
		// 객체를 통한 접근
		FinalTestMain ftm = new FinalTestMain();
		System.out.println(ftm.COMPANY);
		System.out.println(ftm.PHONE);
		// System.out.println(ftm.ADDRESS); 에러 발생(private는 객체를 통한 접근 불가)
		
		// System.out.println(FinalTestMain.COMPANY); 에러 발생
		// System.out.println(FinalTestMain.ADDRESS); 에러 발생
		System.out.println(FinalTestMain.PHONE); // static 선언만 에러 발생 X
		
		ftm.information();
	}
	public static void main(String[] args) {
		new FinalTest().start();
	}

}
