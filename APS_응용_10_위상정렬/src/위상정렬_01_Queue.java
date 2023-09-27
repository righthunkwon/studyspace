import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_01_Queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 인접행렬
		int[][] adjArr = new int[V + 1][V + 1]; // why? 문제에서 1번 정점부터 시작 V번까지
		int[] degree = new int[V + 1]; // 진입차수를 저장할 배열을 하나 생성한다.

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			// 유향이므로 A->B로만 저장하면 되겠다~~~
			adjArr[A][B] = 1; // 가중치가 따로 주어지지 않았기 때문에
			// 진입차수를 증가~~
			degree[B]++;
		} // 입력이 모두 완료가 되었다.

		// 작업이 들어갈 큐 준비 (degree 가 0인 친구들만 들어갈 수 있음)
		Queue<Integer> queue = new LinkedList<>();

		// 초기에 진입차수가 0인 (재료구매, 양념장, 밥하기 같은 선 작업이 없는 친구들을 몽땅 넣어)
		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int work = queue.poll(); // 현재 작업하나 꺼낸다.
			System.out.println(cook[work]); // 작업을 출력해보겠다.
			for (int i = 1; i < V + 1; i++) {
				if (adjArr[work][i] == 1) {
					adjArr[work][i] = 0; // 간선 제거
					degree[i]--; // 진입차수 감소

					// 진입차수가 0이 되었다 라는 말은 선행작업이 완료됨을 의미
					// 고로 큐에 들어갈 준비가 되었다.
					if (degree[i] == 0)
						queue.add(i);
				} // 연결확인
			} // 연결 끊는 작업
		}

	}

	public static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
			+ "5 6\r\n" + "9 6\r\n" + "6 7\r\n" + "";
}
