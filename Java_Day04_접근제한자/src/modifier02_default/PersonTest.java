package modifier02_default;

public class PersonTest {
	public static void main(String[] args) {
		// Person과 PersonTest는 다른 클래스이지만 같은 패키지이다.
		// 따라서 같은 패키지에 접근할 수 있는 default 변수는 접근할 수 있다. 
		Person p = new Person();
		p.info(); // public이니까 당연히 접근 가능
		p.name = "KWON"; // default 클래스 다르더라도 패키지 동일하면 접근 가능
		p.age = 28; // default 클래스 다르더라도 패키지 동일하면 접근 가능
	}
}
