
public class PrivateStudent {
	int num = 999;
	// 캡슐화 : Private으로 정보 보호
	private String name = "kwon"; // 캡슐화
	public PrivateStudent() { 
	// private일 경우 PrivateStudentMain에서의 접근이 차단된다
		
	}
	public void output() { // 캡술화된 변수의 정보를 외부에서 사용할 수 있도록 메소드를 생성해줘야 한다.
		System.out.println(num + ", " + name);
	}
	
	// getter
	public String getName() { 
		return name;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
}
