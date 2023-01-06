
public class ClassTest02 {

	public static void main(String[] args) {
		// new 키워드로 객체를 생성한다.
		// 클래스는 동일하지만 여러 객체를 만들 수 있다.
		// 자동차(클래스)에 들어가는 여러 부품들(객체_이 서로 다른 것처럼 클래스는 동일할지라도 기본적으로 ct1, ct2, ct3는 서로 관계가 없다.
		ClassTest01 ct1 = new ClassTest01();
		ClassTest01 ct2 = new ClassTest01(" ,Test2에서 추가된 데이터(1)");
		ClassTest01 ct3 = new ClassTest01(9999, "Test2에서 추가된 데이터(2)");
		
	}

}
