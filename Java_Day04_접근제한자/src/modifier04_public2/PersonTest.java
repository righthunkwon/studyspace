package modifier04_public2;

import modifier04_public.Person;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.info();
		p.name = "KWON";
		p.age = 28;
	}
}
