
public class ATM2 implements Runnable {

	private int money = 20000;
	
	public ATM2() {
		
	}
	
	/*
		동기화(synchronized)
			
				: 멀티스레드를 잘 사용하면 프로그램적으로 좋은 성능을 낼 수 있지만,
				  멀티스레드 환경에서 반드시 고려해야할 점인 스레드 간 동기화라는 문제를 해결해야 합니다.
				  
				  가령, 스레드간 서로 공유하고 수정할 수 있는 data가 있는데 스레드 간 동기화가 되지 않은 상태에서 
				  멀티스레드 프로그램을 돌리면, data의 안정성과 신뢰성을 보장할 수 없습니다.
				  
				  따라서 data의 thread-safe를 하기 위해 자바에서는 synchronized 키워드를 제공해 스레드간 동기화를 시켜 data의 thread-safe를 가능하게 합니다.
				  자바에서 지원하는 synchronized 키워드는 여러개의 스레드가 한개의 자원을 사용하고자 할 때,
				  현재 데이터를 사용하고 있는 해당 스레드를 제외하고 나머지 스레드들은 데이터에 접근 할 수 없도록 막는 개념입니다.
				  
				  Synchronized 키워드는 변수와 함수에 사용해서 동기화 할 수 있습니다.
				  하지만 Synchronized 키워드를 너무 남발하면 오히려 프로그램 성능저하를 일으킬 수 있습니다.
				  Synchronized 키워드를 사용하면 자바 내부적으로 메서드나 변수에 동기화를 하기 위해 block과 unblock을 처리하게 되는데 
				  이런 처리들이 만약 너무 많아지게 되면 오히려 프로그램 성능저하를 일으킬 수 있기 때문입니다. 
				  따라서 적재적소에 Synchronized 키워드를 사용하는 것이 중요합니다!


			  1. 메서드에서 사용하는 경우 (public과 반환형 사이)
			  	public synchronized void method(){ 실행문 }
			  
			  2. 객체 변수에 사용하는 경우(block문)
			  	private Object obj = new Object();
			  	public void exampleMethod(){ synchronized(obj){ 실행문 }}
	*/  
	
	// 스레드 처리할 실행문을 run() 메소드에 오버라이딩 한 뒤 전체 동기화
	public synchronized void run() {
		// 스레드 시작 시 1000원씩 10번 연속 출금
		for (int i=1; i<=10; i++) {
			getCash(1000);
			
			if(money%2000==0) { // 잔액이 2000의 배수일 때 동기화 해제
				try {
					this.wait(); // 대기모드
				} catch(InterruptedException ie) {
					
				}
			} else { // 잔액이 2000의 배수가 아닐 때
				this.notify(); // 다시 동기화
			}
		}
	}
	
	// 출금처리 메소드(스레드 메소드 전체를 동기화함으로써 오류 해결)
	public void getCash(int cash) {
		if(money >= cash) { // 출금하려는 금액보다 크거나 같을 때
			money -= cash;
			System.out.println(Thread.currentThread().getName()+"출금, 잔액="+money+"원");
		} else { // 출금하려는 금액보다 잔고가 부족할 때
			System.out.println("잔액이 부족합니다. 잔액=" + money);
		}
	}
	
	// 메인 메소드(별개의 파일로 생각)
	public static void main(String[] args) {
		ATM2 atm = new ATM2();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		
		son.setPriority(Thread.MAX_PRIORITY); // 우선순위 부여, 단 이는 먼저 실행된다는 게 아니라, 시스템이 busy할 때 우선순위가 높은 쓰레드에게 먼저 CPU를 할당해준다는 의미
		mother.start();
		son.start();
	}

}
