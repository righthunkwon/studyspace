
// 스레드 처리되는 클래스 생성하기
// 1. Thread 클래스 상속(extends Thread)
public class ThreadTest1 extends Thread {

	String msg;
	
	public ThreadTest1() {
		
	}
	
	public ThreadTest1(String msg) {
		this.msg = msg;
	}
	
	// 2. Thread 처리할 실행문을 run() 메소드에 오버라이딩
	public void run() {
		for(int i=1; ; i++) {
			System.out.println(msg+ "-->" +i);
			try {
				Thread.sleep(200); // sleep() : 실행 지연 메소드, 1000 = 1s, 예외처리 필요
			} catch (InterruptedException ie) {
				
			} 
		}
	}
	
	public static void main(String[] args) {
		
		/*
			public void multiThread() {
				for(int i=1; ; i++) {
					System.out.println(msg+ "-->" +i);
				}
			}
		
		
			case 1) tt1의 객체 생성 이후 tt1.multiThread 무한루프 (tt2는 객체 형성 X, 실행 X)
			
				ThreadTest1 tt1 = new ThreadTest1("첫번째");
				tt1.multiThread();
		
				ThreadTest1 tt2 = new ThreadTest1("두번째");
				tt2.multiThread();


			case 2) tt1, tt2 객체 생성 이후 tt1.multiThread 무한루프 (tt2 실행 X)
			
				ThreadTest1 tt1 = new ThreadTest1("첫번째");
				ThreadTest1 tt2 = new ThreadTest1("두번째");
				
				tt1.multiThread();
				tt2.multiThread();

		*/

		/*
			tt1과 tt2를 동시에 실행하는 방법(단계)
				
				1. Thread 클래스 상속 (Thread는 Runnable이라는 인터페이스로부터 상속)
				2. Thread 처리할 실행문을 run() 메소드에 오버라이딩
				3. start() 메소드 실행
		*/
		
		
		ThreadTest1 tt1 = new ThreadTest1("첫번째");
		ThreadTest1 tt2 = new ThreadTest1("두번째");
		ThreadTest1 tt3 = new ThreadTest1("세번째");
		
		// 3. start() 메소드를 이용하여 자바 가상 머신의 Thread 스케줄러에 등록 (메소드 이름인 run이 아니라 start로 실행!)
		tt1.start(); // 실행되는 순서는 무작위
		tt2.start();
		tt3.start();
	}

}
