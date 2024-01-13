package printstars;

public class PrintStars01 {
	public static void main(String[] args) {
		/*
		 * 	*****
		 *  *****
		 *  *****
		 *  *****
		 *  *****
		 * 
		 * */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 *  11111
		 *  22222
		 *  33333
		 *  44444
		 *  55555
		 * 
		 * */
		int num = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(num);
			}
			num++;
			System.out.println();
		}
		System.out.println();
		
		/*
		 * 12345
		 * 12345
		 * 12345
		 * 12345
		 * 12345
		 * 
		 * */
		num = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(num++);
			}
			num = 1;
			System.out.println();
		}
		System.out.println();
	}
}
