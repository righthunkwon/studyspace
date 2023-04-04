package java04_oop;

public class SubTest extends SuperTest {

	public SubTest()  {
		// 방법 (1) : a=10;
		// 방법 (2) : this(10);
		// 방법 (3) : super(10);
		// 방법 (4) : super.a = 10;
		this.a = 10; // 방법 (5)
		
	}
	public SubTest(int a) {
		super(a);
	}
	
	public static void main(String[] args) {
		SubTest st = new SubTest();
		System.out.println("st.a="+st.a);

	}
}