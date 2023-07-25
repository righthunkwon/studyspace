package abstractclass03;

public class ChefTest {
	public static void main(String[] args) {
		Chef[] chefs = new Chef[2];
		chefs[0] = new KFoodChef();
		chefs[1] = new JFoodChef();

		for (Chef chef : chefs) {
			// 메소드의 동적바인딩(항상 자식 클래스의 메소드가 사용)
			chef.eat();
			// chef.cook(); 부모의 cook() 메소드가 없으므로 컴파일 에러 발생
			
			// instanceof와 형변환을 이용하여 메소드를 호출할 수는 있다.
			// 하지만 이는 불편한 방법이다.
			if(chef instanceof KFoodChef) {
				KFoodChef k = (KFoodChef) chef;
				k.cook();
			} else if (chef instanceof JFoodChef) {
				((JFoodChef)chef).cook();
			}
			
		}
	}
}
