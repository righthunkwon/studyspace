import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		// Random 클래스 : 난수를 구한다.
		Random ran = new Random();
		
		// nextInt() : int범위의 수 중 하나를 무작위로 얻어온다.
		for(int i=1; i<=10; i++) {
			int num = ran.nextInt();
			System.out.print(num+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("===========================================================================");
		
		// Math.abs() : 절대값 구하기
		for(int i=1; i<=10; i++) {
			int num = Math.abs(ran.nextInt()); 
			System.out.print(num+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("===========================================================================");

		// Math.abs() : 최댓값 설정하여 절대값을 구한다.
		for(int i=1; i<=10; i++) {
			int num = Math.abs(ran.nextInt(100));
			System.out.print(num+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("===========================================================================");
		
		// Math.abs(20-0+1) : 0~20 사이의 수범위를 지정하여 값을 구한다.
		for(int i=1; i<=10; i++) {
			int num = Math.abs(ran.nextInt(20-0+1));
			System.out.print(num+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("===========================================================================");
		
		// Math.abs((20-10+1)+10) : 10~20 사이의 수범위를 지정하여 값을 구한다.
		for(int i=1; i<=10; i++) {
			int num = Math.abs(ran.nextInt(20-10+1)+10);
			System.out.print(num+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("===========================================================================");
		
		// ran.nextBoolean(); : true, false
		for(int i=1; i<=10; i++) {
			boolean boo = ran.nextBoolean();
			System.out.print(boo+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("===========================================================================");
	}

}
