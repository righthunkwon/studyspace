
public class ClassTest02 {
	
	// 자동차
	String model; // 모델
	String color; // 색
	int maxSpeed; // 최고속도
	
	// 초기값
	public ClassTest02() {
		print();
	}
	
	// 모델, 색, 최고속도
	public ClassTest02(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		print();
	}
	
	// 최고속도, 모델, 색
	public ClassTest02(int maxSpeed, String model, String color) {
		// this() 	: 같은 클래스의 다른 생성자 호출하기	(단, 반드시 첫번째 실행문으로 명시해야 한다.)
		this(model, color, maxSpeed); // 상단의 모델, 색, 최고속도 순서의 코드를 실행한다.
		
		//		this.maxSpeed = maxSpeed;
		//		this.model = model;
		//		this.color = color;
		//		print();
	}
	
	// print()
	public void print() {
		System.out.println("모델 : "+model);
		System.out.println("색 : "+color);
		System.out.println("최고속도 : "+maxSpeed);
		System.out.println(); // 줄바꿈
	}
	
	

	/*
		메인 메소드
	 		: 메인 메소드가 있어야 실행할 수 있다.
			: 단, 상단에 print();가 선언된 것처럼 그대로 선언할 수 없다.
			" 메인 메소드는 특별한 메소드로 다른 곳에 있는 메소드라고 생각하는 것이 편하다.
	*/
	
	
	// 메인 메소드
	public static void main(String a[]) {
		
		// 세 가지의 객체
		ClassTest02 ct1 = new ClassTest02(); // 초기값
		ClassTest02 ct2 = new ClassTest02("Avante", "grey", 200);
		ClassTest02 ct3 = new ClassTest02(250, "Tesla", "black");
	}
}
