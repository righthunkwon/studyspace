package interface02;

public class KFoodChef implements Chef {
	// 추상클래스를 상속받을 경우 해당 클래스에 존재하는 추상메소드를 오버라이딩하지 않을 경우 에러가 발생한다.
	public void cook() {
		System.out.println("한식을 조리한다.");
	}
}
