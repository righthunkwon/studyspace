package test04_object_serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonReadTest {
	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
			Object obj = ois.readObject();
			System.out.println(obj); // 동적바인딩으로 person의 정보가 잘 출력된다.
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
