import java.util.Scanner;

public class Ex01Operator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
			[처리조건]
			사과의 갯수를 정수로 입력받아 바구니의 수를 구하라.
			단, 한 바구니에는 8개의 사과를 담을 수 있다.
			
			[실행]
			사과의 개수 : 12
			바구니는 두 개가 필요합니다.
		*/
		System.out.print("사과의 개수=");
		int numOfApples = scan.nextInt();
		int sizeOfBucket = 8;
		int numOfBucket = (numOfApples % sizeOfBucket == 0) ? (numOfApples / sizeOfBucket) : (numOfApples / sizeOfBucket) + 1;
		System.out.println("바구니는 " + numOfBucket + "개가 필요합니다.");
		
		// = 와 == 를 제대로 구별하지 않아 오류가 발생하였었다.
	}

}
