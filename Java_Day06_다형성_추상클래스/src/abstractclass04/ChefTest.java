package abstractclass04;

public class ChefTest {
	public static void main(String[] args) {
		Chef[] chefs = new Chef[2];
		chefs[0] = new KFoodChef();
		chefs[1] = new JFoodChef();

		for (Chef chef : chefs) {
			// 메소드의 동적바인딩(항상 자식 클래스의 메소드가 사용)
			chef.eat();
			chef.cook();
		}
		System.out.println("----------------------");
		
		// 다형성
		Chef c1 = new KFoodChef();
		Chef c2 = new JFoodChef();
		c1.cook();
		c2.cook();
	}
}
