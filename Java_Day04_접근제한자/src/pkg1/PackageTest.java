package pkg1;

public class PackageTest {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.pkg);
		
		// 다른 패키지에 속한 같은 클래스명의 클래스는 패키지명을 포함하여 사용할 수 있다.
		pkg1.Person p1 = new pkg1.Person();
		pkg1.pkg2.Person p2 = new pkg1.pkg2.Person();
		pkg1.pkg2.pkg3.Person p3 = new pkg1.pkg2.pkg3.Person();
		
		System.out.println(p1.pkg);
		System.out.println(p2.pkg);
		System.out.println(p3.pkg);
	}
}