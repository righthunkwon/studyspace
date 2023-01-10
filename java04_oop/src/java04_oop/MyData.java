package java04_oop;

public class MyData {
	protected String username = "세종대왕";
	
	// 생성자메소드
	protected MyData() {

	}
	
	// 일반 메소드
	protected String getUserName() {
		return username;
	}
	protected void setUserName(String username) {
		this.username = username;
	}
}
