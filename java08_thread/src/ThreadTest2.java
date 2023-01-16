
// Thread 처리 클래스 생성
// 1. 인터페이스 Runnable 상속
public class ThreadTest2 implements Runnable {
	
	String msg;
	int i=0;
	
	public ThreadTest2() {
		
	}

	public ThreadTest2(String msg) {
		this.msg = msg;
	}

	// 2. Runnable 인터페이스의 추상 메소드 오버라이딩 (스레드 구현코드 기술 : run)
	public void run() {
		while(true) {
			System.out.println(msg+"-->"+ ++i + Thread.currentThread().getName()); // Thread.currentThread() : 현재 실행 중인 스레드 객체 구하기
		}
	}
	
	public static void main(String[] args) {
		// 3. Runnable 인터페이스를 상속받아 run() 메소드를 오버라이딩 한 경우 해당 클래스의 객체를 생성한 이후 Thread 클래스의 객체를 생성하여야 한다.
		ThreadTest2 tt1 = new ThreadTest2("first");
		Thread t1 = new Thread(tt1, "첫번째"); 
		
		ThreadTest2 tt2 = new ThreadTest2("second");
		Thread t2 = new Thread(tt2, "두번째");
		
		ThreadTest2 tt3 = new ThreadTest2("third");
		Thread t3 = new Thread(tt3, "세번째");
		
		
		// 4. Thread 스케쥴러 등록
		t1.start();
		t2.start();
		t3.start();
	}

}
