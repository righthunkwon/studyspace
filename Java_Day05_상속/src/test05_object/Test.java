package test05_object;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Test {
	public static void main(String[] args) {
		// heap 메모리에 Object 객체 생성 - Person 객체 생성(부모) - Student 객체 생성(자식)
		Student st1 = new Student();
		Student st2 = new Student();
		
		st1.name = "kwon";
		st2.name = "kwon"; // true
		// st2.name = "kim"; // false
		
		// Student에서 toString()을 정의하지 않으면, Student의 toSting()이 아니라 Object의 toString() 메소드가 
		// 호출된다. Object의 toString()을 sout하면 test05_object.Student@2a139a55의 결과가 나온다.
		// 하지만, Student에서 이클립스가 제공하는 toString() 메소드를 별도로 정의하면 우리가 원하는 결과를 얻을 수 있다.
		
		System.out.println(st1); // toString() 메소드가 자동으로 호출
		System.out.println(st1.toString()); 
		
		/*
			참고)
			Object의 toString()
			
			public String toString() {
        		return getClass().getName() + "@" + Integer.toHexString(hashCode());
    		}
		*/
		
		// 객체의 주소비교: ==
		// 객체의 주소비교: equals()
		// 객체의 내용비교: 재정의한 equals() 사용
		System.out.println(st1 == st2); // false
		System.out.println(st1.equals(st2)); // false
		// equals() 메소드 오버라이딩
	}

}
