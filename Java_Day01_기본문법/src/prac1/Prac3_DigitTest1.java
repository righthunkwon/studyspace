package prac1;

public class Prac3_DigitTest1 {
	public static void main(String[] args) {
        int num = 1; // 출력 숫자
        int row = 5; // 열 크기

        for (int i = 1; i <= row; i++) { // 열 반복(5회)
            // 공백 출력(1열 0개, 2열 1개, 3열 2개, 4열 3개, 5열 4개)
            for (int j = 1; j < i; j++) {
                System.out.print("\t");
            }

            // 숫자 출력(1열 5개, 2열 4개, 3열 3개, 4열 2개, 5월 1개)
            for (int k = 1; k <= row - i + 1; k++) {
                System.out.print(num + "\t");
                num++;
            }
            System.out.println(); // 줄바꿈
        }
	}
}
