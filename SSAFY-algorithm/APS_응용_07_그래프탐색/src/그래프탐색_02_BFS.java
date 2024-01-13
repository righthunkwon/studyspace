import java.util.LinkedList;
import java.util.Queue;

public class 그래프탐색_02_BFS {
	static int n = 7; // 크기
	static int[][] map; // 인접행렬(무향그래프), 0~6까지의 점
	static boolean[] visited; // 방문배열
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		n = 7;
		visited = new boolean[n];
		map = new int[][] {
			 	{ 0, 1, 1, 0, 0, 1, 0 }, 
			 	{ 1, 0, 0, 1, 0, 0, 1 }, 
			 	{ 1, 0, 0, 1, 0, 0, 0 },
			 	{ 0, 1, 1, 0, 0, 0, 1 }, 
			 	{ 0, 0, 0, 0, 0, 1, 1 }, 
			 	{ 1, 0, 0, 0, 1, 0, 0 }, 
			 	{ 0, 1, 0, 1, 1, 0, 0 } 
			 };
			 
		bfs(0);	
	}
		
	// v : 시작정점
	// bfs의 결과는 항상 최단거리이다.
	static void bfs(int v) {
		visited[v] = true; // 방문처리
		queue.add(v); // 시작정점을 큐에 넣는다.
		
		// 큐가 공백이 될때까지 반복문 수행
		while (!queue.isEmpty()) {

			int tmp = queue.poll(); // 정점을 하나  꺼낸다.
			System.out.println(tmp); // 방문확인

			// 방문하지 않았으면서, 연결된 간선이 존재한다면 재귀호출
			for (int i = 0; i < map.length; i++) {
				if (!visited[i] && map[tmp][i] == 1) {
					visited[i] = true; // 방문처리
					queue.add(i); // 큐에 넣고 방문처리
				}
			}
		}

	}

}
