
public class Array04 {

	public static void main(String[] args) {
		// 배열의 복사
		// 배열은 생성이 되면 크기를 변경할 수 없다.
		// 따라서 새로 배열을 생성하여 기준 배열의 정보를 복사하는 방법을 이용한다.
		// 클래스명.메소드
		// System은 static void 이므로 특별한 작업 없이 바로 사용할 수 있다.
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		/*
		 *	Object src  : 원본 배열명
		 *  int srcPos  : 원본 소스 포지션 지정 (원본의 복사 시작 위치 지정)
		 *	Object dest : 타겟 배열명 (복사할 배열명)
		 * 	int destPos : 타겟 소스 포지션 지정 (복사본의 복사 시작 위치 지정)
		 *  int length  : 원본에서 복사할 데이터 갯수
		 * 
		*/
		
		// 배열 : 변경 불가
		int[] data = {54,87,15,79,34,79,32};
		
		// 새로운 배열을 생성하여 원래 배열 복사(일부 복사, 전체 복사 모두 가능)
		int[] targetData = new int[20]; // 초기값이 0, 공간은 정수형 데이터 20개 저장 가능
		System.arraycopy(data, 2, targetData, 3, 5);
		
		for(int i=0; i<targetData.length; i++) {
			System.out.println("targetData["+i+"]="+targetData[i]);
		}
	}

}
