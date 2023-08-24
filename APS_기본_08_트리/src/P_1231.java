import java.util.Scanner;

// 중위순회
public class P_1231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// test case
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // 노드의 개수

			// 배열로 구현하는 이진트리
			// 배열의 크기를 1칸 크게 만들어 index 1부터 요소를 담는다.

			// SOFTWARE의 경우
			// 0 1 2 3 4 5 6 7 8
			//   W F R O T A E S
			char[] carr = new char[n + 1];
			for (int i = 1; i <= n; i++) {
				int node = sc.nextInt(); // 노드의 번호
				carr[i] = sc.next().charAt(0);

				// 불필요한 입력 버리기
				// 문제 조건 상 완전이진트리이므로 가능
				// 2 * 노드의 번호 <= 8인 경우 왼쪽 자식 노드 존재
				// 2 * 노드의 번호 + 1 <= 8인 경우 오른쪽 자식 노드 존재
				if (2 * node <= n) {
					sc.nextInt(); // 왼쪽 자식 노드 입력
				}
				if (2 * node + 1 <= n) {
					sc.nextInt(); // 오른쪽 자식 노드 입력
				}
			}

			// 중위순회 결과 출력
			System.out.printf("#%d ", t);
			inorder(1, n, carr);
			System.out.println();
		}
	}

	// 중위순회(LVR)
	// i: 현재 방문하고 있는 노드 번호, n: 노드의 개수, carr[]: index가 이진트리를 따르는 배열 
	private static void inorder(int i, int n, char[] carr) {
		if (i <= n) {
			inorder(2 * i, n, carr); // L
			System.out.print(carr[i]); // V
			inorder(2 * i + 1, n, carr); // R
		}
	}
}
