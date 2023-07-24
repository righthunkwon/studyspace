package abstractclass02;

public class ChefTest {
	public static void main(String[] args) {
		Chef[] chefs = new Chef[2];
		chefs[0] = new KFoodChef();
		chefs[1] = new JFoodChef();
		
		for (Chef chef : chefs) {
			// 메소드의 동적바인딩(항상 자식 클래스의 메소드가 사용)
			chef.eat();
			chef.cook();
			
			// 이런 상황에서는 Chef의 cook()은 절대 사용되지 않는다.
			// 하지만, 이를 아예 지워버리면 에러가 발생한다.
			// 이를 위해 우리는 추상 메소드를 정의하여 코드의 목적을 명시할 수 있다.
		}
	}
}
