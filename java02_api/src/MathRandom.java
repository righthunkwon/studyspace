
public class MathRandom {

	public static void main(String[] args) {
		// 난수는 0.0보다 크고 1.0보다 작은 실수를 한 개 만들어준다.
		
		for(int i=1; i<=100; i++) {
			double ran = Math.random();
			//0~100 범위 : 난수 * (큰값-작은값+1)
			int ranInt = (int)(ran*(100-0+1)); // (ran*(40-20+1))로 설정할 경우 20~40의 수를 구해준다.
			System.out.print(ranInt+"\t");
			if(i%10==0) {
				System.out.println();
			}
		}
	}

}
