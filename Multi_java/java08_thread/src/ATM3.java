
public class ATM3 implements Runnable {

	private int money = 20000;
	
	public ATM3() {
		
	}
	
	// 스레드 처리할 실행문을 run() 메소드에 오버라이딩 한 뒤 일부 동기화
	public void run() { 
		// 메소드 내에 일부만 동기화
		synchronized(this) {
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
		ATM3 atm = new ATM3();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		
		son.setPriority(Thread.MAX_PRIORITY); // 우선순위 부여
		mother.start();
		son.start();
	}

}
