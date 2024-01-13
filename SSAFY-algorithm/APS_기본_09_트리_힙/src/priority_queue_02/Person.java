package priority_queue_02;

// 비교기준 작성 필요 : Comparable : 나와 얘 비교
public class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		
		return this.age - o.age;
	}
	
}
