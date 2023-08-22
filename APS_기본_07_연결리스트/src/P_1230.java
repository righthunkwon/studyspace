import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 암호문 1
// alt shift r : 변수명 한 번에 바꾸기
public class P_1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			// 암호 배열
			LinkedList<Integer> arr = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
			}
			int m = sc.nextInt();

			for (int i = 0; i < m; i++) {
				char s = sc.next().charAt(0);
				if (s == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					// 추가할 암호가 있는 명령어 배열
					LinkedList<Integer> tmp = new LinkedList<Integer>();
					for (int j = 0; j < y; j++) {
						tmp.add(sc.nextInt());
					}
					// x번째 위치부터 한 칸씩 증가하며 요소들 추가
					for (int k = 0; k < y; k++) {
						arr.add(x + k, tmp.get(k));
					}
				} else if (s == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = x + 1; j < x + 1 + y; j++) {
						arr.remove(j);
					}
				} else {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						arr.add(arr.size(), sc.nextInt());
					}
				}
			}
			System.out.printf("#%d ", t);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ", arr.get(i));
			}
			System.out.println();
		}
	}
}
