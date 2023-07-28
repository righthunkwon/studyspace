package test04_object_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonWriteTest {
	public static void main(String[] args) {
		Person p = new Person("권정훈", "960617");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
