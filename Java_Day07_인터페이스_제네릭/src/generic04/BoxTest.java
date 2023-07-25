package generic04;

// 제너릭 타입에서의 와일드 카드 이용
// Generic type<?> : 타입에 제한이 없음
// Generic type<? extends T> : T와 T를 상속받은 타입들만 사용 가능
// Generic type<? super T> : T와 T의 조상 타입만 사용 가능
class Person {
	
}

class Student extends Person {
	
}

class PersonBox<T> {
	
}

public class BoxTest {
	public static void main(String[] args) {
		PersonBox<Object> po = new PersonBox<Object>();
		PersonBox<Person> pp = new PersonBox<Person>();
		PersonBox<Student> ps = new PersonBox<Student>();
		 
		// (1) default : 기본
		PersonBox<?> pAll = po;
		pAll = pp;
		pAll = ps;
		
		// (2) extends : 상속
		PersonBox<? extends Person> pChild = pp;
		pChild = ps; // Person의 자손인 Student는 Person에 넣을 수 있다.
		// pChild = po; // 컴파일 에러 발생, Person의 조상인 Object는 Person에 넣을 수 없다. 
		
		// (3) super : 부모
		PersonBox<? super Person> pSuper = pp;
		// pSuper = ps; // 컴파일 에러 발생, Person의 자손인 Student는 Person에 넣을 수 없다.
		pSuper = po; // Person의 조상인 Object는 Person에 넣을 수 있다.
		
	}
}
