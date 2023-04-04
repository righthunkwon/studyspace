
public class PrivateStudentMain {

	public PrivateStudentMain() {
		
		// private 접근제한자는 클래스 외부에서의 접근을 허용하지 않는다.
		// 객체명.필드명, 객체명.메소드(), new 생성자 메소드 모두 차단
		PrivateStudent ps = new PrivateStudent();
		// String n = ps.name; name은 private이므로 실행 불가
		// System.out.println("name : + n");
		ps.output();

		
		String name = ps.getName();
		System.out.println(name);
		
		ps.setName("Lee");
		System.out.println(ps.getName());
	}

	public static void main(String[] args) {
		new PrivateStudentMain();
	}
}
