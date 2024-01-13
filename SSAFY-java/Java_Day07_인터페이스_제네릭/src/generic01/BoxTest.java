package generic01;

// 무엇이든지 담을 수 있는 박스
// 넣을 때는 편하지만 뺄 때는 불편
// 제네릭 사용 X
class Box {
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}

class Kwon {
	
}

public class BoxTest {
	public static void main(String[] args) {
		Box box = new Box();
		box.setObj("문자열"); // 정수, 실수, 문자열, 객체, ...
		Object obj = box.getObj(); // 하지만, set 한 값이 출력되지는 않는다.
		
		if (obj instanceof String) {
			String str = (String) obj;
			System.out.println("문자열입니다.");
		} else if (obj instanceof Kwon) {
			Kwon k = (Kwon) obj;
			System.out.println("Kwon입니다.");
		} else {
			System.out.println("obj입니다.");
		}
		
	}
}
