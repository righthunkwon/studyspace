package java06_abstract_interface;

/*	
	클래스에서 추상메서드들이 있는 interface를 사용하기 위해서는 
	implements 키워드를 사용하여 상속을 받은 뒤 모든 추상 메소드를 오버라이딩 하여야 한다.
*/

// extends 는 한 번만 가능하지만, implements는 여러 번 가능하다(여러 개 상속받을 수 있다).
public class InterfaceTest implements InterfaceA, InterfaceC {

	public InterfaceTest() {

	}

	@Override
	public int hap(int x, int y) {
		return 0;
	}

	@Override
	public int cha(int x, int y) {
		return 0;
	}

	@Override
	public int gob(int x, int y) {
		return 0;
	}

	@Override
	public int mok(int x, int y) {
		return 0;
	}

	@Override
	public String getDouble() {
		return null;
	}

	@Override
	public void setDouble(double n) {

	}

	@Override
	public void output() {
		System.out.println("(Interface A)MAX=" + MAX);
		System.out.println("(Interface B)MAX_DOUBLE=" + MAX_DOUBLE);
		System.out.println("(Interface C)STATUS=" + STATUS);
	}

	public static void main(String[] args) {
		System.out.println(InterfaceA.MAX); // 100

		InterfaceTest it = new InterfaceTest();
		it.output();

		// interface를 상속받은 클래스의 객체생성과 대입
		// new InterfaceA(); ----> interface이므로 객체 생성 불가
		InterfaceA a = new InterfaceTest(); // ----> class이므로 객체 생성 가능, 상위클래스인 InterfaceTest를 InterfaceA로 보냄
		System.out.println("hap()->"+ a.hap(100, 25));
		
		// 
		InterfaceTest it2 = (InterfaceTest)a; // ----> 상위클래스로부터 담았던 객체인 a를 다시 상위클래스인 InterfaceTest에 담을 수 있다.
	}

}
