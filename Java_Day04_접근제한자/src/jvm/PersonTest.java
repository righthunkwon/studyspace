package jvm;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "Yang"; // 경고 X : 인스턴스 변수에는 인스턴스를 통해 접근하므로 자연스러움
		p1.pCount = 10; // 경고 O : 클래스에 저장되는 static을 힙에 저장되는 인스턴스로 접근해서 경고
		System.out.println(p1.pCount); // 경고 O
		System.out.println(Person.pCount); // 경고 X
		
		// 클래스 변수는 인스턴스 생성 없이 접근할 수 있는 공유 메모리이기 때문에 
		// 이클립스는 인스턴스로 접근하는 p1.pCount보다 클래스로 접근하는 Person.pCount를 선호한다.
	}
}
