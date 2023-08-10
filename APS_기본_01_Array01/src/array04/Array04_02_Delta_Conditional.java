package array04;

public class Array04_02_Delta_Conditional {
	static int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9, } };
	static int n = arr.length;

	public static void main(String[] args) {
		// 현재 나의 좌표(3*3배열의 중앙, 2에 위치)
		int r = 0;
		int c = 1;

		// Delta
		// 문제에서 주어진 방향이 있으면 그것을 따르고, 없으면 자유롭게 구현
		// 델타는 1차원으로 구현할 수도 있고 2차원으로 구현할 수도 있다.
		
		// 1차원 델타 구현
		// 배열의 범위 고려(조건 추가)
		// 상하좌우
		int[] dr = { -1, 1, 0, 0 }; // 행
		int[] dc = { 0, 0, -1, 1 }; // 열

		// 2차원 델타 구현
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int d = 0; d < 4; d++) {
			// d = 0, 1, 2, 3
			// 1차원 배열 두 개로 델타 계산
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 2차원 배열로 델타 계산
			int nr2 = r + drc[d][0];
			int nc2 = c + drc[d][1];
			
			// 1 2 3
			// 4 5 6
			// 7 8 9

			// 바로 확인하는 것이 아니라 현재 내 위치가 경계인지 아닌지를 확인하고 확인
			// 1. 영역 안에 들어왔으면 진행시켜
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				System.out.println(arr[nr][nc]);
			}

			// 2. 영역 안에 들어오지 않았으면 진행시키지 마
			if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
				continue;
			}
			System.out.println(arr[nr][nc]);

			// 다음 좌표의 값을 비교하고 범위 체크(위험)
			// 범위를 체크하고 다음 좌표의 값을 비교(안전)
		}
	}
	
	public static boolean isRange(int nr, int nc) {
		// 영역 안에 들어오지 않았으면 진행시키지 마
		if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
			return false;
		}
		return true;
		// 전체를 return 문 하나로 표현 가능
		// return nr < 0 || nr >= n || nc < 0 || nc >= n;
	}
	
	public static boolean isRange2(int nr, int nc) {
		// 영역 안에 들어오면 진행시켜
		if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
			return true;
		}
		return false;
		// 전체를 return 문 하나로 표현 가능
		// return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}

}
