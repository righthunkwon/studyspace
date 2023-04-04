
public class ClassTest01 {

	public static void main(String[] args) {
		// new 키워드로 객체를 생성한다.
		// 클래스는 동일하지만 여러 객체를 만들 수 있다.
		// 자동차(클래스)에 들어가는 여러 부품들(객체가 서로 다른 것처럼 클래스는 동일할지라도 기본적으로 ct1, ct2, ct3는 서로 관계가 없다.)
		ClassTest01Main ct1 = new ClassTest01Main();
		ClassTest01Main ct2 = new ClassTest01Main(8888);
		ClassTest01Main ct3 = new ClassTest01Main(" , 지창현");
		ClassTest01Main ct4 = new ClassTest01Main(9999, "길형태");
		
		// 메소드 호출 : 객체명.메소드명()
		ct1.method1();
		
		String result = ct3.method2(1111, 2222);
		System.out.println("result : "+result);
		System.out.println("myName : "+ct4.getMyName());
		
		
		// 객체 내의 멤버변수의 값 변경하기
		ct4.myName = "권정훈민정음";
		System.out.println("변경된 myName ;"+ct4.getMyName());
		
		
		// 단, 이러한 변화는 ct4이라는 객체 내에서만 이루어짐 (ct1, ct2, ct3의 myName과 비교해볼 것)
		// 즉, 객체 간 정보 공유는 일어나지 않는다.
		System.out.println("기존 myName ;"+ct1.getMyName());
		System.out.println("기존 myName ;"+ct2.getMyName());
		System.out.println("기존 myName ;"+ct3.getMyName());
	}

}
