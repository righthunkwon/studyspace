package interface04;

interface MyPrint1 {
	public default void print() {
		System.out.println("출력1");
	}
}

interface MyPrint2 {
	public default void print() {
		System.out.println("출력2");
	}
}

class PrintClass implements MyPrint1, MyPrint2 {

	// print()를 두 개 만들 수는 없다.
	@Override
	public void print() {
		MyPrint1.super.print();
		MyPrint2.super.print();
	}
	
}

public class PrintTest {
	public static void main(String[] args) {
		PrintClass pc = new PrintClass();
		pc.print();
	}
}
