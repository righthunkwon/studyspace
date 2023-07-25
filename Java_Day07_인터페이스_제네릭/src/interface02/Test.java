package interface02;

public class Test {
	public static void main(String[] args) {
		// (1) 인터페이스
		// 인터페이스는 객체 생성 불가
		// Chef c = new Chef();
		
		// (2) 구현 클래스
		KFoodChef k = new KFoodChef();
		
		// (3) 추상클래스
		// 추상 클래스는 객체 생성 불가
		// JFoodChef j = new JFoodChef();
		
		// (4) 다형성
		Chef c = new KFoodChef();
	}
}
