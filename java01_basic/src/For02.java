
public class For02 {

	public static void main(String[] args) {
		
		// 중첩 반복문 (1)
		// 바깥쪽 for문 : 줄, 안쪽 for문 : 칸
		// for문 내부의 변수도 지역변수이기에 for문이 끝나면 삭제된다. (자바: 자동으로 메모리 제거)
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print(j + "\t");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println("=================================");
		
		
		// 중첩 반복문 (2)
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print(i + "\t");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println("=================================");
		
		
		// 중첩 반복문 (3)별찍기
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println("=================================");

		
		// 중첩 반복문 (4)별찍기
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println("=================================");

		
		// 중첩 반복문 (5)별찍기
		for(int i=1; i<=5; i++) {
			for(int j=5; i<=j; j--) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println("=================================");

		
		// 중첩 반복문 (6)별찍기
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println("=================================");
	}

}
