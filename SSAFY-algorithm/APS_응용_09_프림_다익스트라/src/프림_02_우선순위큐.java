import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 프림_02_우선순위큐 {
	private static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";

	private static class Edge implements Comparable<Edge> {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 인접 리스트
		List<Edge>[] adjList = new ArrayList[V];

		// 리스트 생성
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt(); // 시작정점
			int B = sc.nextInt(); // 끝정점
			int W = sc.nextInt(); // 가중치

			// 무방향 그래프
			adjList[A].add(new Edge(A, B, W));
			adjList[B].add(new Edge(B, A, W));
		}

		// 방문처리
		boolean[] visited = new boolean[V];

		// 우선순위 큐 활용
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		// 시작 정점을 하나 뽑고 시작
		visited[0] = true;

		// 간선을 넣는 다양한 방법
//		// (1)
//		for(int i = 0 ; i<adjList[0].size(); i++) {
//			pq.add(adjList[0].get(i));
//		}
//		
//		// (2)
//		for(Edge e : adjList[0]) {
//			pq.add(e);
//		}
//
//		// (3)
//		pq.addAll(adjList[0]);

		// 간선 넣기
		for (Edge e : adjList[0]) {
			pq.add(e);
		}

		int pick = 1; // 선택한 정점(이미 처음 정점은 선택)
		int ans = 0; // 정답

		while (pick != V) {
			Edge e = pq.poll();

			// 방문했다면 넘기기
			if (visited[e.ed]) {
				continue;
			}

			ans += e.w; // 가중치 누적 계산
			pq.addAll(adjList[e.ed]); // 정점 더하기
			visited[e.ed] = true; // 정점 방문 표시
			pick++; // 선택한 정점의 개수 증가
		}
		System.out.println(ans);
	}
}
