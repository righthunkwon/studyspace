package priority_queue_04;

// 비교기준 작성 필요 : Comparable<Person>
public class Person  {
	public String name;
	public int age;
	
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
}
