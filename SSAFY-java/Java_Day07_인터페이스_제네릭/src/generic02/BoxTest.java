package generic02;

// 박스에 타입 매개변수 지정 (제네릭)
class Box<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}

class Kwon {
	public String getName() {
		return "권정훈";
	}
}

public class BoxTest {
	public static void main(String[] args) {
		// 박스의 타입을 명시
		// Box box = new Box();는 컴파일 에러를 발생시키지는 않지만, 이렇게 작성할 경우 T에 Object가 들어간다.
		Box<String> box1 = new Box<String>();
		box1.setT("Hello");
		String str = box1.getT();
		System.out.println(str);
		
		Box<Kwon> box2 = new Box<Kwon>();
		Kwon k = new Kwon();
		box2.setT(new Kwon());
		System.out.println(k.getName());
	}
}
