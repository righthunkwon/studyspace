package java04_oop;

public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCC c = new CCC();
		System.out.println(c.getData());
		
		//하위 클래스를 객체로 만들어 상위 클래스에 대입하더라도 
		//하위 클래스에서 오버라이딩한 기능은 그대로 적용된다.
		BBB b =new CCC();//객체는 하위 클래스 CCC | 상위 클래스 BBB에 객체를 넣음.
		System.out.println(b.getData());
		//하위 클래스 CCC의 getData가 실행됨.
		
		Object obj =new CCC();	//Object 최 상위
		//System.out.println(obj.getData());
		
		// 상속관계에서 하위클래스 객체를 상위 클래스에 대입 후 
		// 다시 하위클래스로 대입할 수 있다.
		CCC c2 = (CCC)obj;//단 상위 클래스를 하위 클래스로 형변환 시켜야 한다.
		System.out.println(c2.getData());
		
		
		
	}

}
