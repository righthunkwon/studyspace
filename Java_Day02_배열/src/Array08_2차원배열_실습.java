
public class Array08_2차원배열_실습 {

	public static void main(String[] args) {
		int[][] grid = { 
				{ 2, 3, 1, 4, 7 }, 
				{ 8, 13, 3, 33, 1 }, 
				{ 7, 4, 5, 80, 12 }, 
				{ 17, 9, 11, 5, 4, },
				{ 4, 5, 91, 27, 7 } 
		};

		// 2차원배열 전체를 순회하면서 3의 배수의 개수와 총합을 구하라.
		int triTimes = 0;
		int triSum = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] % 3 == 0) {
					triTimes++;
					triSum += grid[i][j]; 
				}
			}
		}
		System.out.println(triTimes);
		System.out.println(triSum);
	}

}
