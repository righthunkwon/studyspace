
public class WrapperTest {

	public static void main(String[] args) {
		
		// Wrapper : 기본 데이터형을 객체로 생성해주는 클래스
		
		// Integer형으로 변경(과거) : Integer intObj = new Integer(num)
		// Integer형으로 변경(현재) : Integer intObj = num; (오토박싱)
		// 오토박싱 : 기본 데이터형을 객체로 자동으로 변환하여 넣어준다.
		int num = 1234;
		Integer intObj = num;
		Integer intObj2 = new Integer(num); // 오류는 나지 않지만 권장하지 않음(오토박싱이 나오기 이전의 방법)
		
		// 오토언박싱 : 객체형을 기본 데이터형으로 자동으로 변환하여 넣어준다.
		int num2 = intObj;
		System.out.println(intObj.MAX_VALUE);
		System.out.println(intObj.floatValue());
		System.out.println(intObj.hashCode());
		
		int age = Integer.parseInt("25");
		System.out.println(age+10);
		double conData = Double.parseDouble("25.9087");
		System.out.println(conData);
		
		System.out.println(Integer.max(97, 81));
	}
}
