package test07_comparable;

// Collections.sort()를 사용하기 위해서는 비교 기준점이 필요하다.
// Comparable : 비교 기준(인터페이스)
public class Person implements Comparable<Person>{
	String name;
	String id;
	
	public Person() {
	}

	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() { // hascCode() 재정의
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) { // equals() 재정의
		if (obj instanceof Person) {
			return id.equals(((Person) obj).id);
		}
		return false;
		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Person o) {
		return Integer.parseInt(this.id) - Integer.parseInt(o.id);
	}
	
	
}
