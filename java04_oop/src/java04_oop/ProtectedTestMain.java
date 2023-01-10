package java04_oop;

public class ProtectedTestMain {

	public ProtectedTestMain() {

	}
	public void start() {
		MyData md = new MyData();
		md.username = "권정훈";
		System.out.println(md.getUserName());
		
		md.setUserName("권오성");
		System.out.println(md.username);
	}
	
	public static void main(String[] args) {
		new ProtectedTestMain().start();
	}

}
