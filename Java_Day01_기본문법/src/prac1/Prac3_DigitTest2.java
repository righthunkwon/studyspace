package prac1;

public class Prac3_DigitTest2 {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 0; i < 3; i++) {
			// 공백(0 1 2)
			for (int j = 0; j < i; j++) {
				System.out.print("\t");
			}
			// 숫자(5 3 1)
			for (int k = 5; k > (2 * i); k--) {
				System.out.print(num + "\t");
				num++;
			}
			System.out.println();
		}
		for (int i = 0; i < 2; i++) {
			// 공백(1 0)
			for (int j = 0; j < 1 - i; j++) {
				System.out.print("\t");
			}
			// 숫자(3 5)
			for (int k = 0; k < (2 * i) + 3; k++) {
				System.out.print(num + "\t");
				num++;
			}
			System.out.println();
		}
	}
}
