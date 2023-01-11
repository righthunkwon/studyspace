package innerclass;

/* 
	내부 클래스
		: 클래스 내에 선언한 클래스
	
		(1) 클래스 영역에 내부 클래스 만들기
		(2) 메소드 내에 내부 클래스 만들기
		(3) 익명의 내부 클래스 만들기(해당 파일) 
			: 클래스명이 존재하지 않는 클래스, 메소드 내에 정의
			: 익명의 내부클래스는 한 번만 사용하거나 자주 사용하지 않을 때 활용한다.
*/
public class AnonymousInnerClass {
	String myName = "권정훈";

	public AnonymousInnerClass() {

	}

	public void start() {
		new Sample() {
			// 내부클래스
			int tot = 120;

			// 메소드
			void totOutput() {
				System.out.println("tot=" + tot);
				System.out.println("myName=" + myName);
			}

			// Sample의 메소드를 오버라이딩
			// 오버라이딩은 상위클래스가 형변환하더라도 오버라이딩 된 기능은 유지한다. 
			public void getSum() {
				int total = 0;
				for (int i = 2; i <= 100; i += 2) {
					total += i;
				}
				System.out.println("evenSum=" + total);
			}
		}.getSum(); //.getOddSum(); //.totOutput();
	}

	public static void main(String[] args) {
		AnonymousInnerClass aic = new AnonymousInnerClass();
		aic.start();
	}
}
