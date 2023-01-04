
public class ContinueTest {

	public static void main(String[] args) {
		// break : 반복문 제어, 반복문 전체를 중단
		// continue : 반복문 제어, 반복문 내에서 반복문의 현재 단계를 중단
	
		for(int i=1; i<=10; i++) {
			if(i%2==1) {
				continue;
			}
			System.out.println(i);
		}
		
		for(int i=1; i<=10; i++) {
			if(i%2==1) {
				break;
			}
			System.out.println(i);
		}
	}
}
