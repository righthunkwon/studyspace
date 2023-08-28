import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 일회용
public class S_15706 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// test case
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 신입사원의 수
			int min = Integer.parseInt(st.nextToken()); // 분반별 최소인원
			int max = Integer.parseInt(st.nextToken()); // 분반별 최대인원

			// 점수 카운트 배열 생성 후 배열 요소 입력
			st = new StringTokenizer(br.readLine());
			int[] score_cnt = new int[101];
			for (int i = 0; i < n; i++) {
				score_cnt[Integer.parseInt(st.nextToken())]++;
			} 

			// 점수 카운트 배열을 누적합 배열로 변환
			for (int i = 1; i < 101; i++) {
				score_cnt[i] += score_cnt[i - 1];
			} 

			// 가장 많은 반의 인원과 가장 적은 반의 인원의 차이
			int ans = Integer.MAX_VALUE;
			
			// 가능한 모든 t1, t2 조합에 대해 반복
			for (int t1 = 2; t1 <= 99; t1++) {
				for (int t2 = t1 + 1; t2 <= 100; t2++) {

					// t1, t2를 기준으로 어학 성적을 A, B, C 분반에 할당
					int A = score_cnt[t1 - 1]; // A 분반 인원
					int B = score_cnt[t2 - 1] - score_cnt[t1 - 1]; // B 분반 인원
					int C = score_cnt[100] - score_cnt[t2 - 1]; // C 분반 인원

					// 각 분반의 인원이 최소 및 최대 인원 조건을 만족할 경우
					if (A >= min && A <= max && B >= min && B <= max && C >= min
							&& C <= max) {
						
						// 가장 많은 인원과 가장 적은 인원의 차이를 계산하여 최소값 갱신
						int maxABC = Math.max(A, Math.max(B, C));
						int minABC = Math.min(A, Math.min(B, C));
						ans = Math.min(ans, maxABC - minABC);
					} else
						continue;
				}
			}
			
			// 만족하는 값이 없을 경우 -1 출력
			if (ans == Integer.MAX_VALUE) {
				ans = -1;
			}
			
			// 정답 출력
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
