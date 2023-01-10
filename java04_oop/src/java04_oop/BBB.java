package java04_oop;

// 클래스에 final을 사용하면 상속이 불가하다.
public class BBB extends AAA {
	int b=20;
	public int getData()	{	//오버라이딩
		return b;
	}
}
