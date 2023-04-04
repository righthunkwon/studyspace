package java04_oop;

public class A {
//	public void test()	{}	//오버 로딩 에러 
							//아래 test()메소드와 동일한 이름과 매개변수 타입을 가지고 있음.
							//오버 로딩 시 동일한 매개 변수 타입이 존재하면 안됨.
	
	public String test()	{
		return "a";
	}
	public double test(int x) {
		return 1.0;
	}

	public static void main(String[] args) {
		A t = new A();
		System.out.println(t.test(25));

	}

}
