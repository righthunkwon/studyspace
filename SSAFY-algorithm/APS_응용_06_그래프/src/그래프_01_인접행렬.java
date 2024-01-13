import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정점의 개수(V)와 간선의 수(E)
		int V = sc.nextInt();
		int E = sc.nextInt();

		// 인접행렬(배열)
		// 1번 ~ V개의 정점 번호를 이용한다라고 가정
		int[][] adjArr = new int[V + 1][V + 1]; 

		// 간선의 정보 입력
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();// 시작정점
			int B = sc.nextInt();// 끝정점
			int w = sc.nextInt();// 가중치 그래프라고 했을때 가중치 값

			
			// 무향그래프(가중치X)
			adjArr[A][B] = 1; 
			adjArr[B][A] = 1; 

			// 무향그래프(가중치O)
			adjArr[A][B] = w; 
			adjArr[B][A] = w; 
			
			// 유향그래프(A→B)
			adjArr[A][B] = 1; // 가중치 있을 경우 w 
			
			// 유향그래프(B→A)
			adjArr[B][A] = 1; // 가중치 있을 경우 w

			// 그래프의 경우 간선 대비 정점이 너무 많을 경우
			// 메모리의 효율성이 떨어진다.
		}
	}
}
