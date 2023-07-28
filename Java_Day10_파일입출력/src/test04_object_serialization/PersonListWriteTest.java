package test04_object_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonListWriteTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Person> list = new ArrayList<>();

		list.add(new Person("안준현", "970301"));
		list.add(new Person("양띵균", "620825"));
		list.add(new Person("박지원", "951123"));
		list.add(new Person("조현수", "950419"));
		list.add(new Person("이수지", "980120"));

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personList.dat"))) {
			oos.writeObject(list);
		} 
	}
}
