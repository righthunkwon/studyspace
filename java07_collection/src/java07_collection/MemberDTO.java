package java07_collection;

public class MemberDTO {

	/*
	 	방대한 데이터를 모두 서버에 저장하기 위해 모든 코드를 기술하는 건 몹시 어렵다. 가령, 
	 	회원 100명의 아이디, 비밀번호, 이름, 연락처, email을 회원1의 아이디 ~ email, 
	 	회원2의 아이디 ~ email을 모두 저장하는 건 무리가 있다. 따라서 어떤 특정 회원 한명의 
	 	정보를 저장해두고 이를 private를 이용해 캡슐화를 한 뒤 이를 반복문을 이용해서 출력하면 
	 	좀 더 효율적이다.
	 	
	 	
		캡슐화된 멤버변수와 getter, setter 메소드가 있는 데이터를 저장할 수 있는 클래스
		
			DTO 클래스(Data Transfer Object)	: setter 이용하여 데이터 변경 가능 
			VO 클래스(Value Object)			: readonly 전용
용
	*/
	
	// 캡슐화 변수
	private String userId; // null
	private String userPwd;
	private String userName;
	private String tel; // 번호는 문자열로 저장한다.
	private String email;
	
	
	public MemberDTO() {
	}
	
	public MemberDTO(String userId, String userName, String tel) {
		this.userId = userId;
		this.userName = userName;
		this.tel = tel;
	}
	
	// getter와 setter는 마우스 우클릭 - source - Generate Getter and Setter를 이용하면 한 번에 만들 수 있다.
	// 추가적으로 Generate toString 등 다양한 기능을 활용할 수 있다.
	
	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", tel=" + tel
				+ ", email=" + email + "]";
	}
	
	// userId
	public String getUserId() { // getter
		return userId; // 메소드 getUserId를 만들 때 get 뒤에 캡슐화 변수를 기술할 때는 첫 글자만 대문자로 바꿔준다.
	}


	public void setUserId(String userId) { 	// setter
		this.userId = userId;
	}
	
	
	// userPwd
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	// userName
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	// tel
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	// email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	// 메인 메서드
	public static void main(String[] args) {

	}

}
