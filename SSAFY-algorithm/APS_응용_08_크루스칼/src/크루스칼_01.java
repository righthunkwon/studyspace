import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 유니온 파인드 알고리즘(Union-Find Algorithm)
// 서로소인 부분집합은 교집합이 없는 집합을 의미
// 집합에 속한 한 요소를 대표자로 삼고, 해당 대표자를 통해 각 집합들을 구분

// 유니온 파인드 알고리즘에서는 트리 자료구조를 활용
// 자식노드가 부모노드를 가리키며 루트 노드가 집합의 대표자
// 대표자를 통해 여러 노드가 있을 때 두 노드가 같은 그래프에 속해있는지 알 수 있음

// 유니온 파인드 알고리즘의 과정
// 1) makeset(i): parent[i] = i로 배열 만들기
// 2) findset(x): x == parent[x]의 조건을 통해 어떤 수 x가 어느 그래프에 속하는지 찾기
// *path compression: findset의 과정에서 모든 노드들이 직접 루트 노드를 가리키도록 포인트를 수정하여 효율화
// 3) union(x,y): parent[findset(y)] = findset(x)를 통해 배열 합치기(이때는 x에 y를 담는 것임을 유의)

// 크루스칼 알고리즘(Kruskal Algorithm)
// 그래프에는 정점(vertex)과 정점을 연결하는 간선(edge)이 있는데, 이때 간선에 가중치를 부여할 수 있음
// 크루스칼은 그래프의 모든 정점들을 가장 적은 비용으로 연결하기 위해, 즉, 간선의 가중치를 최소로하여 정점들을 연결하기 위해 사용!

// 크루스칼 알고리즘의 과정
// 1) 그래프 간선을 가중치를 기준으로 오름차순 정렬
// 2) 사이클이 형성되지 않도록 V-1개의 간선 선택(MST 하에서의 간선의 개수 = 정점의 개수 - 1)

// 신장트리(Spanning Tree)
// 1) 모든 정점을 포함하고, 
// 2) 정점 간 서로 연결이 되어 있으며,
// 3) 싸이클이 존재하지 않는(tree의 기본 조건) 그래프

// 최소신장트리(Minimum Spanning Tree, MST)
// 신장 트리 중 가중치의 합이 최소가 되는 신장 트리가 최소 신장 트리
public class 크루스칼_01 {

	// 대표자(루트노드)를 저장할 배열
	private static int[] parent;

	// 입력 데이터
	private static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int v = sc.nextInt(); // 정점의 개수
		int e = sc.nextInt(); // 간선의 수

		// 간선배열 정의 & 배열 요소 입력
		int[][] edges = new int[e][3];
		for (int i = 0; i < e; i++) {
			edges[i][0] = sc.nextInt(); // [0]: 시작정점
			edges[i][1] = sc.nextInt(); // [1]: 끝정점
			edges[i][2] = sc.nextInt(); // [2]: 가중치
		}

		// (1) 크루스칼 1단계
		// 가중치를 기준으로 간선을 정렬(오름차순)
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2]; // 가중치를 기준으로 정렬
			}
		});

		// Lambda
		// 익명 함수를 간단하게 표현
		// 상단에서 익명 클래스로 선언한 Comparator 부분을 간단히 표현 가능
//		Arrays.sort(edges, (o1, o2) -> {
//			return o1[2]-o2[2];
//		});

		// (2) 크루스칼 2단계
		// 사이클이 발생하지 않도록 v-1개의 간선 선택

		// (2-1) makeset
		// 정점 배열(parent) 만들기
		parent = new int[v];
		for (int i = 0; i < v; i++) {
			parent[i] = i;
		}

		// (2-2) findset & (2-3) union
		int ans = 0; // 최소 비용
		int pick = 0; // 뽑은 간선의 수

		for (int i = 0; i < e; i++) {
			// i번째 간선 이용하여 두개의 정점을 가지고 처리하겠다.
			int x = edges[i][0];
			int y = edges[i][1];

			// 대표자가 다르다는 건
			// 서로 연결이 되어있지 않다는 것이므로 연결 가능
			if (findset(x) != findset(y)) {
				union(x, y); // 그래프 합치기 
				ans += edges[i][2]; // 최소로 되는 가중치의 누적합을 갱신하여 계속 더한다
				pick++; // 간선의 개수 증가
			}
			if (pick == v - 1) break;
		}
		// 정답 출력
		System.out.println(ans);
	}

	private static int findset(int x) {
		// findset(기본)
//		if(x == parent[x]) { 
//			return x;
//		}
//		return findset(parent[x]);

		// Path Compression
		// findset의 과정에서 모든 노드들이 직접 루트 노드를 가리키도록 포인트를 수정하여 효율화
		if (x != parent[x]) {
			parent[x] = findset(parent[x]);
		}
		return parent[x];
	}

	private static void union(int x, int y) {
		// x에 y를 포함시킨다.
		// x의 대표를 y의 대표로 삽입시킨다.
		parent[findset(y)] = findset(x); 
	}
}
