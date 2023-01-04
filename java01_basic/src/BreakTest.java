
public class BreakTest {

	public static void main(String[] args) {
		// break : 반복문을 빠져 나간 뒤 다음 실행문으로 이동
		// 라벨을 만들어 원하는 반복문을 중지시킬 수 있다.
		
		labelTest:for(int i=1; ; i++) {
			System.out.println("i="+i);
			for(int j=1; ; j++) {
				System.out.println("j="+j);
				if(j>=5) {
					break labelTest;
				}
			}
			/* 
				스레드를 활용해서 반복문의 출력속도를 조절할 수 있다. (1000=1s)
				try {
					Thread.sleep(1000); 
				}catch (Exception e) {
					
				}
			*/
		}
	}

}
