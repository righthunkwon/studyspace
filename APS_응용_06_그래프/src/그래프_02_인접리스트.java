import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정점의 개수(V)와 간선의 수(E)
		int V = sc.nextInt();
		int E = sc.nextInt();

		// 인접리스트
		// 1번 ~ V개의 정점 번호를 이용한다라고 가정
		List<Integer>[] adjList = new ArrayList[V + 1];
		
		// 인접리스트를 만들 때에는 Null Pointer Exception을 방지하기 위해 반드시 초기화를 해줘야 한다!
		for (int i = 0; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		
		// 간선의 정보 입력
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt(); // 시작정점
			int B = sc.nextInt(); // 끝정점
			int w = sc.nextInt(); // 가중치 그래프라고 했을때 가중치 값

			// 무향그래프: 노드의 수 = 간선의 수 * 2
			adjList[A].add(B);
			adjList[B].add(A);
			
			// 유향그래프: 노드의 수 = 간선의 수
			adjList[A].add(B);
		}
	}
}
