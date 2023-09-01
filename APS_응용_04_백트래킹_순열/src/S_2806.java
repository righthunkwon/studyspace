import java.util.Scanner;

// N-Queen
// n*n의 체스판에 n개의 퀸이 서로를 공격하지 못하게 두기 위해서는
// 각 행마다 퀸을 하나씩은 반드시 두어야 하므로 체스판을 'board[행] = 열'과 같이
// 1차원 배열로 만들 수 있다. (row: 행  /  board[row]: 열)
public class S_2806 {
	private static int[] board;
	private static int n, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// test case
		int tc = sc.nextInt();		
		for (int t = 1; t <= tc; t++) {
			ans = 0; // test case 마다 정답 초기화

			n = sc.nextInt();
			board = new int[n];
			
			dfs(0); // 0행부터 깊이 우선 탐색
			System.out.printf("#%d %d\n", t, ans);
		}

	}
	
	private static void dfs(int row) {
		// 기저부분(종료조건)
		// 행을 다 돌았을 때(퀸을 다 놓았을 때)
		if (row == n) {
			ans++; 
			return;
		}
		
		// 재귀부분(반복수행)
		for (int col = 0; col < n; col++) {
			// row행의 col열에 퀸을 놓는다.
			board[row] = col; 
			
			// 만약 row행에 퀸을놓을 수 있다면, 다음 행을 탐색한다.
			if (isPromising(row)) {
				dfs(row + 1);
			}
		}
	}
	
	private static boolean isPromising(int row) {
		// 퀸은 서로 같은 행, 같은 열, 대각선에 위치해있으면 안 된다.
		// 이미 행을 기준으로 퀸을 하나씩 배치하고 있기에 유망성 검사는 열과 대각선의 경우에만 실행한다.
		
		// 첫 행(i)부터 입력받은 row 행까지 열과 대각선에 대한 유망성 검사를 실시한다.
		for (int i = 0; i < row; i++) {
			
			// 열 검사
			// 이전 행에 배치된 열 현재 행에 배치된 열이 동일할 경우 두 퀸은 같은 열에 위치하므로 false
			if (board[row] == board[i]) {
				return false;
			} 
			// 대각선 검사
			// 행의 차이와 열의 차이가 같을 경우 두 퀸은 대각선에 위치하므로 false
			else if (Math.abs(row-i) == Math.abs(board[row]-board[i])) {
				return false;
			}
		}
		
		// 유망성 검사를 통과할 경우 다음 행에 대한 검사 진행
		return true;
	}
}

