package modifier03_protected;


public class PersonTest {
	public static void main(String[] args) {
		// Person과 PersonTest는 다른 클래스이지만 같은 패키지이다. 
		Person p = new Person();
		p.info(); // public
		p.name = "KWON"; // protected 같은 패키지 패키지 사용 가능
		p.age = 28; // protected 같은 패키지 패키지 사용 가능
	}
}
