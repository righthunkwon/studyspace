package exception04_Applicatio_exception;

public class UserExceptionTest {
	public static String[] fruits = { "사과", "오렌지", "토마토" };

	public static void main(String[] args) {
//		boolean result = getFruit1("사과");
//		if(result)
//			System.out.println("사과 냠냠");
//		else
//			System.out.println("사과 없어 ㅠ^ㅠ");
//		
//		boolean result2 = getFruit1("사과");
//		if(result2)
//			System.out.println("사과 냠냠");
//		else
//			System.out.println("사과 없어 ㅠ^ㅠ");
		
		try {
			getFruit2("오렌지");
			getFruit2("오렌지");
		} catch (FruitNotFoundExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		getFruit2("수박");
		
		
	}
	
	// 1. 과일의 이름을 매개변수로 받아 존재에 따라 boolean 형태를 반환
	public static boolean getFruit1(String name) {
		for (int i = 0; i < fruits.length; i++) {
			if (fruits[i] != null && fruits[i].equals(name)) {
				fruits[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 2. getFruit1을 참조하여 boolean형태의 반환이 아니라 사용자 정의 예외를 발생
	public static void getFruit2(String name) throws FruitNotFoundExeption {
		for (int i = 0; i < fruits.length; i++) {
			if (name.equals(fruits[i])) {
				fruits[i] = null;
				return;
			}
		}
		// 사용자 정의 예외를 던지기
		throw new FruitNotFoundExeption(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
