package printstars;

public class PrintStars02 {
	public static void main(String[] args) {
		/*
		 * * 
		 * ** 
		 * *** 
		 * ****
		 * *****
		 * 
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 * ***** 
		 * **** 
		 * *** 
		 * ** 
		 * *
		 * 
		 */
		for (int i = 0; i < 5; i++) {
			// 공백
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			// 별
			for (int k = 0; k < 5 - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * 
		 * */
		for (int i = 0; i < 5; i++) {
			// 공백(4 3 2 1 0)
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			// 별(1 2 3 4 5)
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		System.out.println();
		
		/*
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 * 
		 * */
		for (int i = 0; i < 5; i++) {
			// 공백(0 1 2 3 4)
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			// 별(5 4 3 2 1 )
			for (int k = 5; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 *    *
		 *   ***
		 *  *****
		 * *******
		 * 
		 * */
		for (int i = 0; i < 4; i++) {
			// 공백(3 2 1 0)
			for (int j = 0; j < 3 - i; j++) {
				System.out.print(" ");
			}
			
			// 별(1 3 5 7)
			for (int k = 0; k < (2 * i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 * *******
		 *  *****
		 *   ***
		 *    *
		 * 
		 * */
		for (int i = 4; i > 0; i--) {
			// 공백(0 1 2 3)
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			
			// 별 (7 5 3 1)
			for (int k = 0; k < (2 * i) - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 마름모와 모래시계는 영역을 나누어 생각하자.
		
		/*
		 * *****
		 *  ***
		 *   *
		 *  ***
		 * *****
		 * 
		 * */
		for (int i = 0; i < 3; i++) {
			// 공백(0 1 2)
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			// 별(5 3 1)
			for (int k = 5; k > (2 * i); k--) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i < 3; i++) {
			// 공백(1 0)
			for (int j = 0; j < 3 - (2 * i); j++) {
				System.out.print(" ");
			}
			// 별(3 5)
			for (int k = 0; k < (2 * i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		/*
		 *   *
		 *  ***
		 * *****
		 *  ***
		 *   *
		 * 
		 * */
		for (int i = 0; i < 3; i++) {
			// 공백(2 1 0)
			for (int j = 2; j > i; j--) {
				System.out.print(" ");
			}
			// 별(1 3 5)
			for (int k = 0; k < (2 * i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 2; i++) {
			// 공백(1 2)
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			// 별(3 1)
			for (int k = 0; k < 3 - (2 * i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
