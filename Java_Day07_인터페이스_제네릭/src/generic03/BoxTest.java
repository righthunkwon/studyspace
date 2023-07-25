package generic03;

// 제한된 제네릭 클래스
// Box<T>와 같이 선언할 경우 타입문자(T)에 다양한 타입을 대입할 수 있었는데, 
// 타입 부분에 extends를 해줄 경우 타입을 한정시킬 수 있다.
class Box<T extends Kwon> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}

// 사람
class Person {
}

// 권정훈
class Kwon extends Person {
}

// 권정훈주니어
class KwonJunior extends Kwon {
}

public class BoxTest {
	public static void main(String[] args) {
		// 제한된 제네릭 클래스로 인해 타입변수가 제한된다.
		Box<Kwon> box1 = new Box<Kwon>();
		// Box<Kwon> box2 = new Box<KwonJunior>(); 제네릭은 상속관계에 있어도 결코 다르게 쓸 수 없다.
		// Box<KwonJunior> box3 = new Box<Kwon>(); 부모자식 포함관계에 관계없이 제네릭은 통일해서 쓴다.

		// 단, 해당 클래스를 상속받고 있다면 타입 매개변수를 동일하게 하여서는 사용할 수 있다.
		Box<KwonJunior> box2 = new Box<KwonJunior>();
		
		// 부모 클래스는 사용할 수 없다.
		// Box<Person> box3 = new Box<Person>(); 컴파일 에러 발생
	}
}
