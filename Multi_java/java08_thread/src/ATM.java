
public class ATM implements Runnable {

	private int money = 20000;
	
	public ATM() {
		
	}
	
	// 스레드 처리할 실행문을 run() 메소드에 오버라이딩
	public void run() {
		// 스레드 시작 시 1000원씩 10번 연속 출금
		for (int i=1; i<=10; i++) {
			getCash(1000);
		}
	}
	
	// 출금처리 메소드(스레드 메소드를 동기화하지 않아서 코드가 중복하여 실행되므로 오류 발생)
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
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		
		mother.start();
		son.start();
	}

}
