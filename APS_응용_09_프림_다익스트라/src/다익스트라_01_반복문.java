import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 다익스트라 알고리즘 (Dijkstra Algorithm)
// 하나의 시작 정점에서 끝 정점까지의 최단 경로
// 그리디 알고리즘을 바탕으로 작동하며, 프림 알고리즘과 유사하다. 
// 전체 정점을 최소로 연결하는 프림 알고리즘과 달리 다익스트라 알고리즘은 출발점과 도착점의 최단경로를 찾는다.

// 다익스트라 알고리즘의 과정
// 시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식

// 시작정점(s)과 끝정점(t)까지의 최단 경로에 정점(x)이 존재하는데, 
// 이때 s에서 t까지의 최단 경로는 s에서 x까지의 최단 경로와 x에서 t까지의 최단경로로 구성된다.

public class 다익스트라_01_반복문 {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E; // V :정점의 수 , E : 간선의수
	static List<Node>[] adjList; // 인접리스트
	static int[] dist; // 최단 길이를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt(); // 시작정점
			int B = sc.nextInt(); // 도착정점
			int W = sc.nextInt(); // 가중치

			// 유향 그래프
			adjList[A].add(new Node(B, W)); // 인접리스트에 노드 추가
//			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		} // 입력 끝

		dijkstra(0);
		System.out.println(Arrays.toString(dist));

	}

	static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		
		dist[start] = 0;	//시작 정점까지의 거리는 0으로 초기화
		
		for(int i = 0 ; i<V-1; i++) {
			int min = INF;
			int idx = -1;
			
			//선택하지 않은 정점 중 dist가 가장 작은 값을 골라 
			for(int j = 0 ; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break; // 선택할 친구가 없다.
			
			visited[idx] = true; //선택
			
//			//포이치가 더편해
//			for(Node curr : adjList[idx]) {
//				if(!visited[curr.v] && dist[curr.v] > dist[idx]+curr.w) {
//					dist[curr.v] = dist[idx] + curr.w;
//				}
//			}
			
			
			
			for(int j = 0; j<adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);
				
				//방문하지 않았고, 연결 되어있으면서 (인접리스트라 확인하지 않아도 되긴함)
				//이미 가지고 있는 값보다 갱신할 여지가 있으면 갱신 할거야
				if(!visited[curr.v] && dist[curr.v] > dist[idx]+curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";

}
