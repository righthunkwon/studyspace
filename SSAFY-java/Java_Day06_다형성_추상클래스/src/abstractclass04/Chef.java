package abstractclass04;

// 추상 클래스
public abstract class Chef {
	String name;
	int age;
	String speciality;

	public void eat() {
		System.out.println("음식을 먹는다.");
	}

	// 추상 메소드
	public abstract void cook();

	
	/*
		추상메소드
		
			추상 메소드는 추상 클래스에서 작성할 수 있다.
			추상 클래스는 객체를 선언할 수 없다.
			
			부모가 구현하고 싶은 내용이 없다고 해서 구현 자체를 안 해버리면
			동적 바인딩에 의해 자식의 오버라이딩된 함수가 실행되는 기회가 없어지게 된다.
			
			빈 깡통(내용을 아무것도 작성하지 않은 {})을 만들어 놓으면 자식이 구현하든 말든 신경쓰지 않는다.
			반면 abstract으로 만들어 놓으면 자식클래스는 무조건 이를 구현해야 하는 의무를 가진다.
			(빈 깡통과 abstract의 차이는 강제성이다)

			추상클래스는 미완성의 설계도이다. 추상 클래스를 통해서는 인스턴스를 생성할 수 없다.
			단, 미완성된 부분을 완성해주면 된다. 익명클래스 문법을 이용하면 1회 한정으로 구현하고 
			인스턴스를 만들 수 있다. 익명클래스 뒤에는 반드시 ;를 붙여줘야 한다.
			
			Chef c2 = new Chef() {
				@Override
				public void cook() {
					System.out.println("아무요리나 가능!");
				}
			};
			c2.cook(); // 아무요리나 가능!
		*/
}
