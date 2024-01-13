import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합
public class S_3289 {
	private static int n;
	private static int m;
	private static int parent[];
	private static StringBuilder sb;
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 집합의 수
			m = Integer.parseInt(st.nextToken()); // 연산의 수

			// makeset
			// 대표자를 담을 배열 생성 및 배열 요소 입력
			parent = new int[n+1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}

			// findset & union
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken()); // 연산
				int x = Integer.parseInt(st.nextToken()); // 시작정점
				int y = Integer.parseInt(st.nextToken()); // 끝정점
				
				int nx = findset(x);
				int ny = findset(y);
				
				// 0: 합집합
				if (operation == 0) {
					union(nx, ny);
				}
				// 1: 같은 집합인지 여부
				else if (operation == 1) {
					
					if (nx == ny) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.printf("#%d %s\n", t, sb);
		}
	}

	// findset
	public static int findset(int x) {
		// path compression
		if (x != parent[x]) {
			parent[x] = findset(parent[x]);
		}
		return parent[x];
	}

	// union
	public static void union(int x, int y) {
		parent[y] = x; 
	}

}
