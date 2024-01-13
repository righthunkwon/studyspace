package test04_object_serialization;

import java.io.Serializable;

// 직렬화
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String name;
	String pNum;
	
	public Person() {
		
	}

	public Person(String name, String pNum) {
		this.name = name;
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", pNum=" + pNum + "]";
	}

	
}
