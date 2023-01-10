package innerclass;
	/* 
		내부 클래스
			: 클래스 내에 선언한 클래스
		
			(1) 클래스 영역에 내부 클래스 만들기
			(2) 메소드 내에 내부 클래스 만들기(해당 파일)
			(3) 익명의 내부 클래스 만들기
	
	*/
public class MethodInnerClass {
	String email = "JaeYongLee@gmail.com";
	public MethodInnerClass() {
		System.out.println("MethodInnerClass()생성자메소드");
	}
	public void emailOutput() {
		System.out.println("이메일 : " + email);
	}
	
	// 외부클래스 내의 메소드
	public void createInner() {
		// 메소드 내의 지역변수
		int num = 100;
		
		// 메소드 내에 내부 클래스 만들기
		class InnerClass {
			String name = "이재용";
			InnerClass() {
				System.out.println("num : "+num);
				System.out.println("name : "+name);
			}
			void getInformation() {
				emailOutput(); // 외부클래스의 메소드 호출
			}
		}
		
		// 메소드 내에서 정의한 내부 클래스의 객체 만들기
		InnerClass ic = new InnerClass();
		ic.getInformation();
	}
	
	// 메인 메소드
	public static void main(String[] args) {
		MethodInnerClass mic = new MethodInnerClass();
		mic.createInner(); // 메소드 내에서 정의한 내부 클래스의 객체를 만든 이후(InnerClass ic = new InnerClass();) 실행 가능하다.
	}

}
