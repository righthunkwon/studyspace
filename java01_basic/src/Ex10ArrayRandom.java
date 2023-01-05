import java.util.Arrays;
import java.util.Random;import javax.swing.ProgressMonitorInputStream;

public class Ex10ArrayRandom {

	public static void main(String[] args) {
		Random ran = new Random();
		
		// 1~1000 사이의 값을 100개 만들어 배열에 저장하고 총합, 평균, 최댓값, 최솟값을 구하라.
		// 단, max()와 min()은 사용하지 않을 것.
		
		/*
			[실행 결과]
			총합=
			평균=
			최댓값=
			최솟값=
		*/

		// 데이터 준비
		int[] data = new int[100];
		for (int i=0; i<data.length; i++) {
			data[i] = ran.nextInt(1000)+1; // 0~999
		}
		
		// 데이터 출력
		System.out.println("데이터 : "+Arrays.toString(data));
		
		// 계산
		int tot=0;
		int max = data[0];
		int min = data[0];
		
		for(int i=0; i<data.length; i++) {
			// 총합
			tot += data[i];
			
			// 최댓값
			if(max < data[i]) {
				max = data[i];
			}
			
			// 최솟값
			if(min > data[i]) {
				min = data[i];
			}
		}
		
		// 평균
		int avg = tot / data.length;

		// 출력
		System.out.println("총합="+tot);
		System.out.println("평균="+avg);
		System.out.println("최댓값="+max);
		System.out.println("최솟값="+min);
	}

}
