package modifier05_getter_setter;

public class Person {
	// 외부 접근 불가
	private String name;
	private int age;
	private boolean hungry;

	// 생성자를 이용하여 인스턴스 변수들을 초기화하여 접근
	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	// getter & setter를 통해 접근
	// getter(접근자) : get멤버변수명, 반환값 O (적절한 자료형 명시)
	// setter(설정자) : set멤버변수명, 반환값 X (void)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	// setter에 조건 걸기
	public void setAge(int age) {
		if (age < 0 || age > 120) {
			System.out.println("장난 치지마!");
			return;
		}
		this.age = age;
	}
	
	// boolean type은 getter에서 get이 아니라 is를 활용한다.
	public boolean isHungry() {
		return hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

}
