package polymorphism01;

public class TypeCastingTest {
	public static void main(String[] args) {
		Person p = new Person();
		// Object obj = p; (O)
		// Student st = p; (X) ... 컴파일 에러
		// 자손타입 객체를 조상타입에 담을 수는 있지만
		// 조상타입 객체를 자손타입에 담을 수는 없다(형변환하여 담아야 한다).
		
//		Person p2 = new Person(); // 메모리상에는 Object와 Person만 만들어짐
// 		Person p2 = new Student(); // 메모리상에 Object, Person, Student 모두 만들어짐
		
		// 에러는 발생하지 않지만 메모리상에 Student 객체가 없으므로 조건문이 false가 되어 작동하지 않는다. 
		if (p instanceof Student) {
			((Student) p).study(); 
		}	
		
		Person ps = new Student();
		// 메모리상에 Object, Person, Student 모두 존재하므로 코드가 정상적으로 실행된다.
		if (ps instanceof Student) {
			((Student) ps).study(); 
		}	
	}
}
