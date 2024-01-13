
public class 그래프탐색_01_DFS {
	private static int n = 7; // 크기
	private static int[][] map; // 인접행렬(무향그래프), 0~6까지의 점
	private static boolean[] visited; // 방문배열

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
		
		dfs(0);
	}
	
	// v: 현재정점
	private static void dfs(int v) {
		visited[v] = true; // 방문처리
		System.out.println(v); // 방문확인
		
		// 방문하지 않았으면서, 연결된 간선이 존재한다면 재귀호출
		for (int i = 0; i < n; i++) {
			if (!visited[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
		
	}
}
