package java06_abstract_interface;

	/*	
		클래스에서 추상메서드들이 있는 interface를 사용하기 위해서는 
		implements 키워드를 사용하여 상속을 받은 뒤 모든 추상 메소드를 오버라이딩 하여야 한다.
	*/
public class InterfaceTest implements InterfaceA{

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
	
	public static void main(String[] args) {
		System.out.println(InterfaceA.MAX);
	}

}
