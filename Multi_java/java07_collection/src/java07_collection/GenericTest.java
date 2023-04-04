package java07_collection;

	/*
		제네릭에 사용되는 기호들(약속)
		
			V	: Value 정수, 실수 등 기본 데이터 타입
			K	: Key 인덱스와 같은 키워드
			E	: Element 객체
	*/

public class GenericTest<V, E> {
	// private Integer num; 처럼 원래 선언한 타입이 아니라 V타입으로 변경
	private V num;
	private E name;
	
	
	public GenericTest() {
		
	}
	
	// toString
	// toString은 마우스 우클릭 - source - Generate toString()를 이용해서 쉽게 만들 수 있다.
	@Override
	public String toString() {
		return "GenericTest [num=" + num + ", name=" + name + "]";
	}

	
	// getter, setter
	// getter, setter는 마우스 우클릭 - source - Generate Getters and Setters를 이용해서 쉽게 만들 수 있다.
	// 일반메소드, num의 getter setter
	public V getNum() {
		return num;
	}

	public void setNum(V num) {
		this.num = num;
	}

	// 일반메소드, name의 getter setter
	public E getName() {
		return name;
	}

	public void setName(E name) {
		this.name = name;
	}
	
}
