package innerclass;
	/* 
		내부 클래스
			: 클래스 내에 선언한 클래스
			
			(1) 클래스 영역에 내부 클래스 만들기(해당 파일)
			(2) 메소드 내에 내부 클래스 만들기
			(3) 익명의 내부 클래스 만들기
	*/
public class OuterClass {
	int productNo = 123;
	String productName = "컴퓨터";
	public OuterClass() {
		System.out.println("OuterClass()생성자");
	}
	public void productList() {
		System.out.println("상품번호 : " + productNo);
		System.out.println("상품명 : " + productName);
	}
	public void creatInner() {
		// 내부클래스 객체를 외부클래스의 영역에서 사용할 때는 그냥 사용할 수 있다.
		InnerClass i1 = new InnerClass();
		i1.memberOutput();
	}

	
	// 1. 클래스 영역의 내부 클래스
	class InnerClass {
		int code = 999;
		String userId = "kwon";
		
		InnerClass() {
			System.out.println("InnerClass()생성자");
		}
		void memberOutput() {
			System.out.println(code+"="+userId);
		}
		void changeData() {
			// 내부클래스(자기자신)에 있는 데이터 변경(자연스럽게 가능)
			code = 888;
			memberOutput();

			// 외부클래스에 있는 데이터 변경 : 내부클래스에서는 외부클래스를 사용할 수 있다.
			productNo = 555; // 내부클래스에서 외부클래스의 멤버변수에 접근 가능 
			productList(); // 내부클래스에서 외부클래스의 메소드에 접근 가능
		}
	}
	
	
	// 메인 메서드 (별도의 파일)
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.productList();
		oc.creatInner();
		
		// 내부 클래스의 객체 생성 : "외부클래스.내부클래스 내부클래스객체 = 외부클래스객체.new 내부클래스()"
		OuterClass.InnerClass oi = oc.new InnerClass();
		oi.memberOutput();
		oi.changeData();
		
		
	}

}
