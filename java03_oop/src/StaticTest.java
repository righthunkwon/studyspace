import java.util.jar.Attributes.Name;

public class StaticTest {
	
	// static
	// 멤버변수, 메소드에 static을 표기한다.
	// 멤버변수에 static은 데이터형 왼쪽에 기술한다.
	// 멤버변수에 접근할 때 객체를 생성하지 않고 클래스명.멤버변수로 접근이 가능하다.
	// 객체를 여러 개 만들더라도 static 변수는 한 개만 존재한다. (싱글톤)
	// static에서는 static 변수만 사용 가능하다. 
	
	// 멤버변수들은 접근 제한자가 생략되었는데, 이 때는 default가 생략된 것이다.
	int num = 10;
	String name = "권정훈";
	static String Local = "강남구";
	
	public StaticTest() {
		
	}
	
	// 메소드에 static 만들기
	// 객체를 만들지 않고도 호출하여 사용할 수 있다.
	public static void testMethod() {
		System.out.println("Local "+Local);
	}
	public void print() {
		System.out.println("num="+num);
	}
	
	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		// 값변경, 한 번만 바꿔도 static 변수는 하나만 존재하므로 전체가 바뀐다.
		// Local 이라는 변수는 static으로 선언되어 있으므로 공유된다.
		st1.Local = "영등포구";
		
		System.out.println("st1 : "+st1.Local);
		System.out.println("st2 : "+st2.Local);
		System.out.println("st3 : "+st3.Local);
		System.out.println(StaticTest.Local);
		System.out.println("pi : "+Math.PI); // PI라는 변수는 이미 static에 속해있기 때문에 사용할 수 있다.
		
		st1.print();
		// testMethod()는 static 메소드이므로 하나만 존재하고, 클래스명.메소드명으로 호출할 수 있다.
		StaticTest.testMethod();
	}

}

class Test01 {
	
}

class Test02 {
	
}