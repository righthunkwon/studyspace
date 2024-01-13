package test04_object_serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonListReadTest {
	public static void main(String[] args) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personList.dat")) ){
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
