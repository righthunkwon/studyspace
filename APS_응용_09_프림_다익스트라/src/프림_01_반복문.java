import java.util.Arrays;
import java.util.Scanner;

// 프림 알고리즘(Prim Algorithm)
// 무향 그래프에서 최소신장트리(MST)를 찾는 알고리즘
// 매 순간 최선의 조건을 선택하는 그리디 알고리즘을 바탕
// 크루스칼과 같은 용도이지만 상황마다 효율이 달라질 수 있기에 알아두는 게 좋음

// 프림 알고리즘의 과정
// 1) 임의의 한 정점을 선택하고 트리 집합에 넣는다.
// 		(혹은 boolean 배열에 전체 정점을 담고 이를 true로 변경해준다)
// 		(임의의 정점을 선택해도 구현되지만 보통 시작 정점(index:0 or 1)을 선택해주는 게 좋다)
// 2) 간선이 연결하는 두 노드 중 가장 낮은 가중치의 간선과 연결된 정점을 트리 집합에 넣는다.
//		(이때 사이클이 형성되면 정점을 담지 않는다)
// 3) 모든 정점이 트리 집합에 포함될 때까지 이를 반복한다.

// 크루스칼 알고리즘과 프림 알고리즘의 차이
// 크루스칼 알고리즘과 프림 알고리즘 모두 최소신장트리를 구하는 알고리즘
// 그래프 내 간선이 적으면 크루스칼 알고리즘이, 간선이 많으면 프림 알고리즘이 유리

// 하지만, 이 과정에서 크루스칼 알고리즘은 
// 모든 간선을 가중치를 기준으로 오름차순으로 정렬하고
// 이 간선들을 순서대로 모든 정점이 연결될 때까지 연결

// 반면에, 프림 알고리즘은 임의의 시작점과 현재까지 연결된 정점들에서
// 아직 연결되지 않은 정점들에 대해 가장 가중치가 낮은 정점을 연결하는 정점 선택 기반으로 동작
// 새로운 정점을 연결할 때마다 새로운 정점에서 갈 수 있는 아직 연결되지 않은 정점들에 대한 간선을 추가해주어야 함
// 우선순위 큐를 이용한 최소 힙으로 구할 수 있고, 다익스트라 알고리즘과 구현 방식이 유사

public class 프림_01_반복문 {
	private static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int v = sc.nextInt(); // 정점의 수
		int e = sc.nextInt(); // 간선의 수

		// 인접 행렬 배열 요소 입력
		int[][] arr = new int[v][v];

		for (int i = 0; i < e; i++) {
			int x = sc.nextInt(); // 시작정점
			int y = sc.nextInt(); // 끝정점
			int w = sc.nextInt(); // 가중치

			// 무향그래프
			arr[x][y] = w;
			arr[y][x] = w;
		}

		// 정점 상태 판단 배열(뽑히면 true, 안 뽑히면 false)
		boolean[] visited = new boolean[v];

		// 대표값의 크기는 정점의 개수로 v가 맞지만,
		// 최소신장트리를 만족하는 가중치를 저장할 때는
		// v개의 정점을 한 번씩 지나는 간선의 개수만큼 공간을 만들어야 하므로 v-1의 크기를 설정해줘야 한다.

		// 하지만, 프림 알고리즘에서는
		// dist 배열의 시작 정점 값에 0을 집어 넣고 이후에 index번호를 가진 정점으로 갈 때
		// 간선의 가중치를 저장하므로 이미 초기값을 저장했으니 v-1이 아니라 v만큼의 공간을 저장하여 v-1만큼의 가중치를 저장한다.
		int[] parent = new int[v]; // 부모(대표값) (문제의 조건에 따라 필요)
		int[] dist = new int[v]; // idx의 번호를 가진 정점에 대한 간선의 가중치값(가중치를 저장하는 배열)

		// 배열 요소 초기화
		for (int i = 0; i < v; i++) {
			parent[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}

		// 임의의 한점을 선택(시작점을 선택)
		dist[0] = 0; // 첫 번째 정점을 시작점으로 선택

		// 프림 알고리즘
		int ans = 0;
		for (int i = 0; i < v; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			// 아직 뽑지 않은 간선 중 가장 작은 간선의 가중치와 인덱스를 뽑는다.
			for (int j = 0; j < v; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			visited[idx] = true;// 정점 선택(뽑기)

			// 선택한 정점과 연결된 정점 중 선택할 수 있는 정점으로 향하는
			// 간선의 최소값을 계속해서 갱신하며 찾는다.
			for (int j = 0; j < v; j++) {
				// 해당 정점을 아직 방문하지 않았고, 직전에 선택한 정점과 연결되어 있으며, 간선의 가중치가 더 작으면
				if (!visited[j] && arr[idx][j] != 0 && arr[idx][j] < dist[j]) {
					dist[j] = arr[idx][j]; // 가중치를 갱신한다.
					parent[j] = idx; // 부모정보를 갱신한다. (문제의 조건에 따라 필요)
				}
			}
		}

		// 최소로 선택된 간선의 가중치를 더한다.
		for (int i = 0; i < v; i++) {
			ans += dist[i];
		}

		// 간선의 가중치 출력
		System.out.println(ans);
	}

	private static long prim() {
		int n = 3;
		int[][] arr = new int[n][n];
		long[] minEdge = new long[n];
		boolean[] visited = new boolean[n];

		// prim 알고리즘 사용할 거라 모든 점 최대값으로 설정.
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0; // 임의의 점인 0번 인덱스를 시작점으로 만들어주기

		long result = 0; // 최소신장트리 비용
		int cnt = 0; // 정점 개수

		while (true) {
			long min = Integer.MAX_VALUE;
			int minNo = 0;
			for (int i = 0; i < n; i++) { // 최소점 찾기
				if (!visited[i] && min > minEdge[i]) {
					minNo = i;
					min = minEdge[i];
				}
			}
			// 최소 점 찾았으니 방문 처리 후 정점 값 더해주기
			visited[minNo] = true;
			result += min;
			if (++cnt == n)
				break;
			// 최소점부터 다른 점들 거리 더 짧은 길로 갱신
			for (int i = 0; i < n; i++) {
				if (!visited[i] && minEdge[i] > arr[minNo][i]) {
					minEdge[i] = arr[minNo][i];
				}
			}
			return result;
		}
		return 0;
	}
}
