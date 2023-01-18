import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

// 파일로 객체를 저장하기(직렬화) : 인터페이스 Serializable를 상속시켜준다. (implements Serializable)
public class VectorTest implements Serializable{
	String msg = "객체로 만들기";
	
	// 컬렉션은 데이터의 집합을 의미하며, 객체를 저장하고 보관하는 기능을 가진 자료구조 처리를 해준다.
	// 컬렉션은 다양한 타입의 객체를 저장할 수도 있고, 하나의 타입(제너릭)만 저장하도록 설정할 수도 있다.
	// 컬렉션 프레임워크의 인터페이스 : list 계열, set 계열 (+Map 계열)
	
	public VectorTest() {
	}
	public Vector getData() {
		// Vector : list 계열로 순서를 유지, index 가짐, 중복객체 저장됨 
		Vector vector = new Vector();
		
		// 다섯 개의 데이터
		String name = "권정훈";
		int age = 28; // 1
		Calendar now = Calendar.getInstance(); // 현재 시간
		now.set(2020,10,25);
		Random random = new Random();
		MemberDTO mem = new MemberDTO("ioTest", "권프로", "010-1111-2222");
		
		vector.add(name); // [0]
		vector.add(age); // [1]
		vector.addElement(now); // [2]
		vector.addElement(mem); // [3]
		vector.addElement("세종대왕"); // [4]

		return vector;
	}
	

}

	/*
			Java 컬렉션 프레임워크(데이터의 집합, 그룹 = 자바의 인터페이스를 사용하여 구현됨)
			
			Collection
				List	: LinkedList, Stack, Vector, ArrayList (순서를 유지하고 저장, 중복 저장 가능)
				Set		: HashSet, SortedSet (순서를 유지하지 않고 저장, 중복 저장 불가)
			
			Map (키와 값의 쌍으로 저장, 키는 중복 저장 불가)
				Hashtable
				HashMap
				SortedMap -> TreeMap
			
	*/
