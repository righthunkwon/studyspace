
public class Array02 {

	public static void main(String[] args) {
		
		// 배열 생성 시 초기값 설정하기
		// null을 생성하여 여유공간을 확보할 수도 있다.
		String colorName[] = new String[] {"RED", "GREEN", "BLUE", "YELLOW", null, null};
		for(int idx=0; idx<colorName.length; idx++) {
			System.out.println("colorName["+idx+"]="+colorName[idx]);
		}
		
		int score[] = {25,95,36,48,75}; // new int[] 생략 가능
		for(int i=0; i<score.length; i++) {
			System.out.println("score["+i+"]="+score[i]);
		}
		
		// 확장된 for문 (데이터 형 : 배열형 변수 or 컬렉션)
		for(int data : score) {
			System.out.println(data);
		}
	}

}
